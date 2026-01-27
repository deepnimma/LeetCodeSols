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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    } // inorderTraversal

    private void dfs(TreeNode curr, List<Integer> ans) {
        if (curr == null) return;

        dfs(curr.left, ans);
        ans.add(curr.val);
        dfs(curr.right, ans);
    } // dfs
} // Solution