class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < ans.length; i++) {
            int n = nums.get(i);
            int a = -1;
            for (int j = 1; j < n; j++) {
                if ((j | (j + 1)) == n) {
                    a = j;
                    break;
                } // if
            } // for

            ans[i] = a;
        } // for

        return ans;
    } // minBitwiseArray
} // Solution