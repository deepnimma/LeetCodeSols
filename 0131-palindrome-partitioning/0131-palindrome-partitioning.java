class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<>(), s);
        return res;
    } // partition

    private void dfs(int start, List<List<String>> res, List<String> curr, String s) {
        if (start >= s.length()) res.add(new ArrayList<>(curr));

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                dfs(end + 1, res, curr, s);
                curr.remove(curr.size() - 1);
            } // if
        } // for
    } // dfs

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        } // while

        return true;
    } // isPalindrome
} // Solution