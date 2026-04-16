class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(
                        dp[row - 1][col],
                        dp[row][col - 1]
                    );
                } // if-else
            } // for
        } // for

        // printArr(dp);

        return dp[m][n];
    } // longestCommonSubsequence

    private void printArr(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            } // for
            System.out.println();
        } // for
        System.out.println();
    } // printArr
} // Solution