class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long cnt = 0;
        int left = 0, right = 0;
        int n = nums.length;

        while (left < n) {
            while (right < n - 1 && nums[right] != nums[right + 1]) right++;
            long size = right - left + 1;
            cnt += (size * (size + 1)) / 2;
            right++;
            left = right;
        } // while

        return cnt;
    } // countAlternatingSubarrays
} // Solution