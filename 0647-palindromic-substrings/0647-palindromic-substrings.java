class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            cnt++;
            dp[i][i] = true;
        } // for

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
                dp[i][i + 1] = true;
            } // if
        } // for

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                if (s.charAt(i) == s.charAt(i + diff) && dp[i + 1][i + diff - 1]) {
                    dp[i][i + diff] = true;
                    cnt++;
                } // if
            } // for
        } // for

        return cnt;
    } // countSubstrings
} // Solution