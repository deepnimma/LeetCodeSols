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
    int cnt = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        int currMax = root.val;
        bfs(root, currMax);

        return cnt;
    } // goodNodes 

    private void bfs(TreeNode node, int currMax) {
        if (node == null) return;

        if (node.val > currMax) {
            bfs(node.right, node.val);
            bfs(node.left, node.val);
        } else {
            cnt++;
            bfs(node.right, currMax);
            bfs(node.left, currMax);
        } // if-else
    } // bfs
} // Solution