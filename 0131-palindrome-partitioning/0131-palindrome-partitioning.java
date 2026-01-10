class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, res, new ArrayList<>(), s);
        return res;
    } // partition

    private void dfs(int st, List<List<String>> res, List<String> curr, String s) {
        if (st >= s.length()) res.add(new ArrayList<>(curr));

        for (int e = st; e < s.length(); e++) {
            if (isPalindrome(s, st, e)) {
                curr.add(s.substring(st, e + 1));

                dfs(e + 1, res, curr, s);
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