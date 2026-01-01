class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;

        backtrack(0, new ArrayList<>(), 0, candidates, target);

        return new ArrayList<>(ans);
    } // combinationSum

    private void backtrack(int first, List<Integer> curr, int currSum, int[] candidates, int target) {
        if (currSum > target) return;
        if (currSum == target) {
            List<Integer> copy = new ArrayList<>(curr);
            Collections.sort(copy);
            ans.add(new ArrayList<>(copy));
            return;
        } // if

        for (int i = first; i < candidates.length; i++) {
            curr.add(candidates[i]);
            currSum += candidates[i];
            backtrack(first, curr, currSum, candidates, target);
            currSum -= candidates[i];
            curr.remove(curr.size() - 1);
        } // for
    } // backtrack
} // Solution