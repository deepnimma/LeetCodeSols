/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return dfs(root, 0);
    } // maxDepth

    private int dfs(Node curr, int depth) {
        if (curr == null) return depth;
        int currMax = Integer.MIN_VALUE;

        for (Node child : curr.children) {
            currMax = Math.max(currMax, dfs(child, depth + 1));
        } // for

        return Math.max(currMax, depth + 1);
    } // dfs
} // Solution