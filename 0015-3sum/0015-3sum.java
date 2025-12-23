class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> solutions = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    solutions.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                } // if-else if-else
            } // while
        } // for

        return List.copyOf(solutions);
    } // threeSum
} // Solution