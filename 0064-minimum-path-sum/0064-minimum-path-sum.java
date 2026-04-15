class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        // top row?
        for (int col = 1; col < grid[0].length; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        } // for

        // first col
        for (int row = 1; row < grid.length; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        } // for

        // printArr(dp);

        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            } // for
        } // for

        // printArr(dp);

        return dp[grid.length - 1][grid[0].length - 1];
    } // minPathSum

    private void printArr(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            } // for
            System.out.println();
        } // for
    } // printArr
} // Solution