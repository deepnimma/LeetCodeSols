class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int found = seen.getOrDefault(diff, -1);

            if (found != -1 && found != i) return new int[]{found, i};
            else seen.put(nums[i], i);
        } // for

        return new int[]{-1, -1};
    } // twoSum
} // Solution