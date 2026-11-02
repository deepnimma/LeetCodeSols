class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            seen.put(nums[i], i);
        } // for

        for (int i = 0; i < nums.length; i++) {
            if (seen.getOrDefault(target - nums[i], -1) != -1) {
                if (seen.get(target - nums[i]) != i) return new int[]{seen.get(target - nums[i]), i};
            } // if
        } // for

        return new int[]{-1, -1};
    } // twoSum
} // Solution