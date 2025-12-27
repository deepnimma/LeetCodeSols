class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j)) return true;
                } // if
            } // for
        } // for

        return false;
    } // exist 

    private boolean dfs(char[][] board, String word, int i, int j) {
        if (word.equals("")) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (word.charAt(0) != board[i][j]) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean up = dfs(board, word.substring(1, word.length()), i - 1, j);
        boolean down = dfs(board, word.substring(1, word.length()), i + 1, j);
        boolean left = dfs(board, word.substring(1, word.length()), i, j + 1);
        boolean right = dfs(board, word.substring(1, word.length()), i, j - 1);

        board[i][j] = temp;

        return up || down || left || right;
    } // dfs
} // Solution