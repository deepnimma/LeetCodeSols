class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    } // combinationSum2

    private void backtrack(
        List<List<Integer>> ans,
        List<Integer> curr,
        int[] candidates,
        int totalLeft,
        int index
    ) {
        if (totalLeft < 0) return;
        else if (totalLeft == 0) {
            ans.add(new ArrayList<>(curr));
        } else {
            for (int i = index; i < candidates.length && totalLeft >= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;

                curr.add(candidates[i]);
                backtrack(
                    ans,
                    curr,
                    candidates,
                    totalLeft - candidates[i],
                    i + 1
                );
                curr.remove(curr.size() - 1);
            } // for
        } // if-else if-else
    } // backtrack
} // Solution