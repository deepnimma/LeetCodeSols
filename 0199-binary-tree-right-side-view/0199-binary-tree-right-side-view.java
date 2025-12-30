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
    public List<Integer> rightSideView(TreeNode root) {
        List<Stack<Integer>> levels = new ArrayList<>();
        bfs(root, levels, 0);
        List<Integer> ans = new ArrayList<>();

        for (Stack<Integer> s : levels) {
            ans.add(s.pop());
        } // for

        return ans;
    } // rightSideView

    private void bfs(TreeNode curr, List<Stack<Integer>> levels, int depth) {
        if (curr == null) return;

        Stack<Integer> lvl;
        try {
            lvl = levels.get(depth);
        } catch (IndexOutOfBoundsException ioobe) {
            levels.add(new Stack<>());
            lvl = levels.get(depth);
        } // try-catch

        lvl.push(curr.val);

        bfs(curr.left, levels, depth + 1);
        bfs(curr.right, levels, depth + 1);
    } // bfs
} // Solution