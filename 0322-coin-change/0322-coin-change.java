class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            int minimumNumber = Integer.MAX_VALUE;
            int j = 0;
            while (j < coins.length && i - coins[j] >= 0 && coins[j] <= amount) {
                if (dp[i - coins[j]] != -1) {
                    minimumNumber = Math.min(dp[i - coins[j]], minimumNumber);
                } // if
                j++;
            } // while

            dp[i] = (minimumNumber == Integer.MAX_VALUE) ? -1 : minimumNumber + 1;
        } // for

        return dp[amount];
    } // coinChange
} // Solution