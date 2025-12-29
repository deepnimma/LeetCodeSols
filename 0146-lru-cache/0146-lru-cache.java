class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        } // Node
    } // Node

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    Map<Integer, Node> m = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    } // LRUCache

    private void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    } // addNode

    private void deleteNode(Node delNode) {
        Node prev = delNode.prev;
        Node next = delNode.next;

        prev.next = next;
        next.prev = prev;
    } // deleteNode
    
    public int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key);
            int ans = resNode.val;

            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            m.put(key, head.next);
            return ans;
        } // if

        return -1;
    } // get
    
    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        } // if

        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        } // if

        addNode(new Node(key, value));
        m.put(key, head.next);
    } // put
} // LRUCache

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */