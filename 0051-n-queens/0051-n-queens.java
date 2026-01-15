class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) board[i][j] = '.';

        backtrack(0, res, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, n);

        return res;
    } // solveNQueens

    private List<String> createBoard(char[][] board) {
        List<String> currBoard = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            String currRow = new String(board[row]);
            currBoard.add(currRow);
        } // for

        return currBoard;
    } // createBoard

    private void backtrack(
        int row,
        List<List<String>> res,
        Set<Integer> diagonals,
        Set<Integer> antiDiagonals,
        Set<Integer> cols,
        char[][] state,
        int n
    ) {
        if (row == n) {
            res.add(createBoard(state));
            return;
        } // if

        for (int col = 0; col < n; col++) {
            int currDiag = row - col;
            int currAntiDiag = row + col;

            if (
                cols.contains(col) ||
                diagonals.contains(currDiag) ||
                antiDiagonals.contains(currAntiDiag)
            ) continue;

            cols.add(col);
            diagonals.add(currDiag);
            antiDiagonals.add(currAntiDiag);
            state[row][col] = 'Q';

            backtrack(row + 1, res, diagonals, antiDiagonals, cols, state, n);

            cols.remove(col);
            diagonals.remove(currDiag);
            antiDiagonals.remove(currAntiDiag);
            state[row][col] = '.';
        } // for 
    } // backtrack
} // Solution