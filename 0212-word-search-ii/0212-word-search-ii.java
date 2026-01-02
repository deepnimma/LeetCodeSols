class Solution {
    char[][] board = null;
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            char[] wc = word.toCharArray();

            for (char c : wc) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                } // if-else
            } // for

            node.word = word;
        } // for

        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root);
                }
            } // for
        } // for

        return this.result;
    } // findWords

    private void backtracking(int i, int j, TrieNode node) {
        char l = this.board[i][j];
        TrieNode currNode = node.children.get(l);

        if (currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        } // if

        this.board[i][j] = '#';

        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int row = i + rowOffset[k];
            int col = j + colOffset[k];

            if (
                row < 0 ||
                row >= board.length ||
                col < 0 ||
                col >= board[0].length
            ) continue;

            if (currNode.children.containsKey(this.board[row][col])) {
                backtracking(row, col, currNode);
            } // if
        } // for

        this.board[i][j] = l;

        if (currNode.children.isEmpty()) {
            node.children.remove(l);
        } // if
    } // backtracking
} // Solution

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode() {}
} // TrieNode