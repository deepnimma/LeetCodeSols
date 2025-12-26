/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> copyMap = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            copyMap.put(curr, new Node(curr.val));
            curr = curr.next;
        } // while

        curr = head;

        while (curr != null && curr.next != null) {
            copyMap.get(curr).next = copyMap.get(curr.next);
            curr = curr.next;
        } // while

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                copyMap.get(curr).random = copyMap.get(curr.random);
            } // if

            curr = curr.next;
        } // while

        return copyMap.get(head);
    } // copyRandomList
} // Solution