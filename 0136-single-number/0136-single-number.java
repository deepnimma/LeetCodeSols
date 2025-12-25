class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int num = 0;

        for (int i : nums) num ^= i;

        return num;
    } // singleNumber
} // Solution