class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            seen.put(nums[i], i);
        } // for

        for (int i = 0; i < nums.length; i++) {
            int found = seen.getOrDefault(target - nums[i], -1);
            if (found != -1 && found != i) return new int[]{found, i};
        } // for

        return new int[]{-1, -1};
    } // twoSum
} // Solution