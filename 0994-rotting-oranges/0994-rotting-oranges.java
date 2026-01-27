class Solution {
    int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int depth = 2;

        while (bfs(grid, rows, cols, depth)) depth++;

        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1;
            } // for
        } // for

        return depth - 2;
    } // orangesRotting

    private boolean bfs(int[][] grid, int rows, int cols, int depth) {
        boolean continuable = false;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == depth) {
                    for (int[] d : dirs) {
                        int nRow = r + d[0], nCol = c + d[1];
                        if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols) {
                            if (grid[nRow][nCol] == 1) {
                                grid[nRow][nCol] = depth + 1;
                                continuable = true;
                            } // if
                        } // if
                    } // for 
                } // if
            } // for
        } // for

        return continuable;
    } // bfs
} // Solution