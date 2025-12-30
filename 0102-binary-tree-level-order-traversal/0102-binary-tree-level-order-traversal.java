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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> holder = new ArrayList<>();
        bfs(root, holder, 0);
        return holder;
    } // levelOrder

    private void bfs(TreeNode node, List<List<Integer>> holder, int depth) {
        if (node == null) return;

        List<Integer> currLevel;
        try {
            currLevel = holder.get(depth);
        } catch (IndexOutOfBoundsException ioobe) {
            holder.add(new ArrayList<>());
            currLevel = holder.get(depth);
        } // try-catch

        currLevel.add(node.val);

        bfs(node.left, holder, depth + 1);
        bfs(node.right, holder, depth + 1);
    } // bfs
} // Solution