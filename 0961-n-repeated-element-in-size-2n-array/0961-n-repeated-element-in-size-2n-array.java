class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        } // for

        for (int k : map.keySet()) {
            if (map.get(k) == n) return k;
        } // for

        return -1;
    } // repeatedNTimes
} // Solution