class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> combo = new ArrayList<>();
        backtrack(0, combo, nums);
        return ans;
    } // subsets

    private void backtrack(int first, List<Integer> curr, int[] nums) {
        ans.add(new ArrayList<>(curr));

        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        } // for
    } // backtrack
} // Solution