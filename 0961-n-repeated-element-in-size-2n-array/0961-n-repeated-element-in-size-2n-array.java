class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] n = new int[10001];

        for (int i : nums) {
            if (n[i] != 0) return i;
            n[i]++;
        } // for

        return -1;
    } // repeatedNTimes
} // Solution