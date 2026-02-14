/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        if (root == null) return null;
        Node copy = new Node(root.val, new ArrayList<>());
        // Node dummy = new Node(-1, new ArrayList<>());
        // dummy.children.add(copy);
        dfs(root, copy);
        // return dummy.children.get(0);
        return copy;
    } // cloneTree

    private void dfs(Node curr, Node copyCurr) {
        if (curr == null) return;

        for (Node child : curr.children) {
            Node copyChild = new Node(child.val, new ArrayList<>());
            dfs(child, copyChild);
            copyCurr.children.add(copyChild);
        } // for
    } // dfs
} // Solution