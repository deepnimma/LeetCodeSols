class Solution {
    public int missingNumber(int[] nums) {
        int tot = (nums.length + 1) * nums.length / 2;
        int sum = 0;

        for (int i : nums) sum += i;

        return tot - sum;
    } // missingNumber
} // Solution