class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res[i] = nums[i];
            } else if (nums[i] < 0) {
                int a = (i - Math.abs(nums[i])) % n;
                res[i] = nums[a < 0 ? n + a : a];
            } else {
                res[i] = nums[(i + nums[i]) % n];
            } // if-else if-else
        } // for

        return res;
    } // constructTransformedArray
} // Solution