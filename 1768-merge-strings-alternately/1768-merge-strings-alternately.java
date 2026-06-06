class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = new String();
        int i = 0, j = 0;
        int n = word1.length(), m = word2.length();

        while (i < n && j < m) {
            ans += word1.charAt(i++);
            ans += word2.charAt(j++);
        } // while

        while (i < n) {
            ans += word1.charAt(i++);
        } // while

        while (j < m) {
            ans += word2.charAt(j++);
        } // while

        return ans;
    } // mergeAlternatively
} // Solution