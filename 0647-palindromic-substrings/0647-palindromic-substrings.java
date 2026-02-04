class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if (n == 0 || n == 1) return n;

        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int cnt = n;

        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (c[i] == c[i + 1]) {
                cnt++;
                dp[i][i + 1] = true;
            } // if
        } // for

        for (int diff = 2; diff <= n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;

                if (c[i] == c[j] && dp[i + 1][j - 1]) {
                    cnt++;
                    dp[i][j] = true;
                } // if
            } // for
        } // for

        return cnt;
    } // countSubstrings
} // Solution