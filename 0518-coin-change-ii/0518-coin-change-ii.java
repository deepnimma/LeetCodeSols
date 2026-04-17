class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            } // for

            // printArr(dp);
        } // for

        return dp[coins.length][amount];
    } // change

    private void printArr(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row) {
                System.out.print(val + " ");
            } // for
            System.out.println();
        } // for
        System.out.println();
    } // printArr
} // Solution