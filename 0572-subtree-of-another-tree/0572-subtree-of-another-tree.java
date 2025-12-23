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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    } // isSubtree

    private boolean dfs(TreeNode curr, TreeNode subRoot) {
        if (curr == null) return false;

        boolean lbool = dfs(curr.left, subRoot);
        boolean rbool = dfs(curr.right, subRoot);

        return checkSameTree(curr, subRoot) || lbool || rbool;
    } // dfs

    private boolean checkSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        boolean lbool = checkSameTree(p.left, q.left);
        boolean rbool = checkSameTree(p.right, q.right);

        return (p.val == q.val) && lbool && rbool;
    } // checkSameTree
} // Solution