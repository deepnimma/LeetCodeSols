class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        Map<Integer, Integer> freq = new HashMap<>();
        double floor = Math.floor((double) nums.length / 3);

        for (int i : nums) {
            // Add number
            freq.put(i, freq.getOrDefault(i, 0) + 1);

            // Shenanigans
            if (freq.get(i) > floor) ans.add(i);
        } // for

        return new ArrayList<>(ans);
    } // majorityElement
} // Solution