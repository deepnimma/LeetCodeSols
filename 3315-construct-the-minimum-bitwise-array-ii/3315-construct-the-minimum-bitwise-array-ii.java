class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < ans.length; i++) {
            int n = nums.get(i);
            int a = -1;
            int d = 1;

            while ((n & d) != 0) {
                a = n - d;
                d <<= 1;
            } // while

            ans[i] = a;
        } // for

        return ans;
    } // minBitwiseArray
} // Solution