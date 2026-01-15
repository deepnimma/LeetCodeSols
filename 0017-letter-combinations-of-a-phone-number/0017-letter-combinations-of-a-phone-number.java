class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> letters = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
        );

        backtrack(0, new StringBuilder(), res, letters, digits);

        return res;
    } // letterCombinations

    private void backtrack(int start, StringBuilder curr, List<String> res, Map<Character, String> letters, String digits) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        } // if

        char[] poss = letters.get(digits.charAt(start)).toCharArray();
        for (char c : poss) {
            curr.append(c);
            backtrack(start + 1, curr, res, letters, digits);
            curr.deleteCharAt(curr.length() - 1);
        } // for
    } // backtrack
} // Solution