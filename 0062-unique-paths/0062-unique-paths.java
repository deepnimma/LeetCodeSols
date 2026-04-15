class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // First row
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        } // for

        // First Col
        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        } // for

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            } // for
        } // for

        return dp[m - 1][n - 1];
    } // uniquePaths
} // Solution