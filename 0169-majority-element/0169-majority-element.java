class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);

        int majority = -1;
        int highestFreq = -1;

        for (int key : freq.keySet()) {
            if (freq.get(key) > highestFreq) {
                majority = key;
                highestFreq = freq.get(key);
            } // if
        } // for

        return majority;
    } // majorityElement
} // Solution