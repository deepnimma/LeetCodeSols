class WordDictionary {
    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();
    } // WordDictionary
    
    public void addWord(String word) {
        TrieNode node = trie;
        char[] c = word.toCharArray();

        for (char ch : c) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            } // if

            node = node.children.get(ch);
        } // for

        node.word = true;
    } // addWord
    
    public boolean search(String word) {
        return searchInNode(word, trie);
    } // search

    private boolean searchInNode(String word, TrieNode node) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (!node.children.containsKey(c)) {
                if (c == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        } // if
                    } // for
                } // if

                return false;
            } else {
                node = node.children.get(c);
            } // if-else
        } // for

        return node.word;
    } // searchInNode
} // WordDictionary

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;

    public TrieNode() {}
} // TrieNode

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */