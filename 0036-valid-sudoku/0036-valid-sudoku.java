class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean row = checkRow(board, i);
            boolean col = checkCol(board, i);

            if (!row || !col) return false;
        } // for

        boolean one = checkSquare(board, 0, 0);
        boolean two = checkSquare(board, 3, 0);
        boolean three = checkSquare(board, 6, 0);
        boolean four = checkSquare(board, 6, 3);
        boolean five = checkSquare(board, 6, 6);
        boolean six = checkSquare(board, 3, 6);
        boolean seven = checkSquare(board, 0, 6);
        boolean eight = checkSquare(board, 0, 3);
        boolean nine = checkSquare(board, 3, 3);

        return (one && two && three && four && five && six && seven && eight && nine);
    } // isValidSudoku

    private boolean checkRow(char[][] board, int row) {
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') continue;
            if (visited.contains(board[row][i])) return false;
            visited.add(board[row][i]);
        } // for

        return true;
    } // checkRow

    private boolean checkCol(char[][] board, int col) {
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') continue;
            if (visited.contains(board[i][col])) return false;
            visited.add(board[i][col]);
        } // for

        return true;
    } // checkCol

    private boolean checkSquare(char[][] board, int sRow, int sCol) {
        Set<Character> visited = new HashSet<>();

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == '.') continue;
                if (visited.contains(board[i][j])) return false;
                visited.add(board[i][j]);
            } // for
        } // for

        return true;
    } // checkSquare
} // Solution