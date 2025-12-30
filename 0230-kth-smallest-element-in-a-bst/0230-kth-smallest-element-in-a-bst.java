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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> holder = new ArrayList<>();

        inorder(root, holder);

        return holder.get(k - 1);
    } // kthSmallest

    private void inorder(TreeNode node, List<Integer> al) {
        if (node == null) return;

        inorder(node.left, al);
        al.add(node.val);
        inorder(node.right, al);
    } // inorder
} // Solution