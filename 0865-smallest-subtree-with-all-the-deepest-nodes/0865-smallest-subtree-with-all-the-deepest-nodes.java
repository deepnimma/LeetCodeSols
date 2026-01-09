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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    } // subtreeWithAllDeepest

    private Custom dfs(TreeNode node) {
        if (node == null) return new Custom(null, 0);
        Custom L = dfs(node.left);
        Custom R = dfs(node.right);
        if (L.dist > R.dist) return new Custom(L.node, L.dist + 1);
        if (R.dist > L.dist) return new Custom(R.node, R.dist + 1);
        return new Custom(node, L.dist + 1);
    } // dfs

    class Custom {
        TreeNode node;
        int dist;
        public Custom(TreeNode p, int dist) {
            node = p;
            this.dist = dist;
        } // Custom
    } // Custom
} // Solution