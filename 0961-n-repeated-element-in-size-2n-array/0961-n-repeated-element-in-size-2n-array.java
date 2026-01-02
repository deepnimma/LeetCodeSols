class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int i : nums) {
            if (s.contains(i)) return i;
            s.add(i);
        } // for

        return -1;
    } // repeatedNTimes
} // Solution