/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class LevelInfo {
        int sum;
        int lvl;

        public LevelInfo(int sum, int lvl) {
            this.sum = sum;
            this.lvl = lvl;
        } // LevelInfo
    } // LevelInfo

    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        int depth = 0;

        bfs(levels, depth, root);

        List<LevelInfo> sums = new ArrayList<>();
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> lvl = levels.get(i);
            int sum = 0;
            for (int j : lvl) {
                sum += j;
            } // for
            sums.add(new LevelInfo(sum, i + 1));
        } // for

        Collections.sort(sums, (a, b) -> Integer.compare(b.sum, a.sum));
        System.out.println(sums.get(0).sum);
        return sums.get(0).lvl;
    } // maxLevelSum 

    private void bfs(List<List<Integer>> lvls, int depth, TreeNode node) {
        if (node == null) return;

        if (lvls.size() <= depth) lvls.add(new ArrayList<>());

        bfs(lvls, depth + 1, node.left);
        bfs(lvls, depth + 1, node.right);

        lvls.get(depth).add(node.val);
    } // bfs
} // Solution