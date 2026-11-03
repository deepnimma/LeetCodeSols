class Solution {
    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        int j = 0;

        for (int n : nums) buckets[n]++;
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            while (cnt < buckets[i]) {
                nums[j++] = i;
                cnt++;
            } // while
        } // for
    } // sortColors
} // Solution