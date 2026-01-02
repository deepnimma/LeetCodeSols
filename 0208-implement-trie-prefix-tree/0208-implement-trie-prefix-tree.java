class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); 
    } // Trie
    
    public void insert(String word) {
        TrieNode node = root;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr)) {
                node.put(curr, new TrieNode());
            } // if
            node = node.get(curr);
        } // for

        node.setEnd();
    } // insert
    
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char curr = word.charAt(i);

            if (node.containsKey(curr)) {
                node = node.get(curr);
            } else {
                return null;
            } // if-else
        } // for

        return node;
    } // searchPrefix
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    } // search
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);

        return node != null;
    } // startsWith
} // Trie

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    } // TrieNode

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    } // containsKey

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    } // get

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    } // put

    public void setEnd() {
        isEnd = true;
    } // setEnd

    public boolean isEnd() {
        return isEnd;
    } // isEnd
} // TrieNode

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */