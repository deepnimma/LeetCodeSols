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
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    } // maxDepth

    private int dfs(TreeNode curr, int depth) {
        if (curr == null) return depth;

        int ldepth = dfs(curr.left, depth + 1);
        int rdepth = dfs(curr.right, depth + 1);
        depth = Math.max(depth, Math.max(ldepth, rdepth));

        return depth;
    } // dfs
} // Solution