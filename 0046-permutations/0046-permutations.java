class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    } // permute

    private void backtrack(
        List<Integer> curr,
        List<List<Integer>> ans,
        int[] nums
    ) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        } // if

        for (int n : nums) {
            if (!curr.contains(n)) {
                curr.add(n);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            } // if
        } // for
    } // backtrack
} // Solution