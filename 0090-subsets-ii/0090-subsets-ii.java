class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        backtrack(new ArrayList<>(), new ArrayList<>(), ans, nums, 0);
        return new ArrayList<>(ans);
    } // subsetsWithDup

    private void backtrack(List<Integer> curr, List<Integer> index, Set<List<Integer>> ans, int[] nums, int idx) {
        List<Integer> copy = new ArrayList<>(curr);
        Collections.sort(copy);
        ans.add(copy);

        for (int i = idx; i < nums.length; i++) {
            if (!index.contains(i)) {
                curr.add(nums[i]);
                index.add(i);
                backtrack(curr, index, ans, nums, idx + 1);
                curr.remove(curr.size() - 1);
                index.remove(index.size() - 1);
            } // if
        } // for
    } // backtrack
} // Solution