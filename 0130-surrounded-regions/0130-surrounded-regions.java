class Solution {
    int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    public void solve(char[][] board) {
        Set<List<Integer>> edges = new HashSet<>();

        // First and Last Col
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'O') dfs(board, row, 0, edges);
            if (board[row][board[0].length - 1] == 'O') dfs(board, row, board[0].length - 1, edges);
        } // for

        // First and Last Row
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') dfs(board, 0, col, edges);
            if (board[board.length - 1][col] == 'O') dfs(board, board.length - 1, col, edges);
        } // for

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(row);
                temp.add(col);

                if (!edges.contains(temp)) {
                    board[row][col] = 'X';
                } // if
            } // for
        } // for
    } // solve

    private void dfs(char[][] grid, int row, int col, Set<List<Integer>> edges) {
        List<Integer> curr = new ArrayList<>();
        curr.add(row);
        curr.add(col);

        if (edges.contains(curr)) return;

        // System.out.println("Adding: " + row + " " + col);

        edges.add(curr);

        for (int[] d : dirs) {
            int nRow = row + d[0], nCol = col + d[1];

            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length) {
                if (grid[nRow][nCol] == 'O') {
                    grid[nRow][nCol] = 'X';
                    dfs(grid, nRow, nCol, edges);
                    grid[nRow][nCol] = 'O';
                } // if
            } // if
        } // for
    } // dfs
} // Solution