class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        int subSetSum = sum / 2;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) dp[j] |= dp[j - curr];
        } // for

        return dp[subSetSum];
    } // canPartition
} // Solution