class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int n1 = s1.length();
        int n2 = s2.length();
        int sum = 0;

        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + (int)s1.charAt(i - 1);
        } // for

        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + (int)s2.charAt(i - 1);
        } // for

        // printMatrix(dp);

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + (int)s1.charAt(i - 1),
                        dp[i][j - 1] + (int)s2.charAt(j - 1)
                    );
                } // if-else
                // printMatrix(dp);
                // System.out.println(">>> ===== <<<");
            } // for
        } // for

        return dp[n1][n2];
    } // minimumDeleteSum

    private void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            } // for

            System.out.println();
        } // for
    } // printMatrix
} // Solution