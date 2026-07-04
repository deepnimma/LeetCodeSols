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
    int longestStreak = 1;
    public int longestConsecutive(TreeNode root) {
        dfs(root, 1);

        return longestStreak;
    } // longestConsecutive

    private void dfs(TreeNode curr, int currStreak) {
        if (curr == null) return;

        if (curr.left != null && curr.left.val == curr.val + 1) {
            longestStreak = Math.max(currStreak + 1, longestStreak);
            dfs(curr.left, currStreak + 1);
        } else dfs(curr.left, 1);

        if (curr.right != null && curr.right.val == curr.val + 1) {
            longestStreak = Math.max(currStreak + 1, longestStreak);
            dfs(curr.right, currStreak + 1);
        } else {
            dfs(curr.right, 1);
        } // if-else
    } // dfs
} // Solution