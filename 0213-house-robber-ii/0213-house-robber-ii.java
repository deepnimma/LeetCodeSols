class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
            robber(nums, 0, nums.length - 2),
            robber(nums, 1, nums.length - 1)
        );
    } // rob

    private int robber(int[] nums, int start, int end) {
        int one = 0;
        int two = 0;

        for (int i = start; i <= end; i++) {
            int temp = one;
            int curr = nums[i];
            one = Math.max(curr + two, one);
            two = temp;
        } // for

        return one;
    } // robber
} // Solution