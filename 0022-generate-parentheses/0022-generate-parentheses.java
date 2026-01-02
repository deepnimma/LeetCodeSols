class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    } // generateParanthesis

    private void backtrack(List<String> ans, StringBuilder sb, int lc, int rc, int n) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        } // if

        if (lc < n) {
            sb.append("(");
            backtrack(ans, sb, lc + 1, rc, n);
            sb.deleteCharAt(sb.length() - 1);
        } // if

        if (lc > rc) {
            sb.append(")");
            backtrack(ans, sb, lc, rc + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        } // if
    } // backtrack
} // Solution