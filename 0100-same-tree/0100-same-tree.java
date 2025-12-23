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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return doubleDfs(p, q);
    } // isSameTree

    private boolean doubleDfs(TreeNode l, TreeNode r) {
        if (r == null && l == null) return true;
        if (r == null || l == null) return false;
        if (l.val != r.val) return false;

        boolean lbool = doubleDfs(l.left, r.left);
        boolean rbool = doubleDfs(l.right, r.right);

        return (l.val == r.val) && lbool && rbool;
    } // doubleDfs
} // Solution