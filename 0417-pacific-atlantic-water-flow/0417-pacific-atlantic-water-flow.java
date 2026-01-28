class Solution {
    int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        // DFS - Pacific Ocean
        for (int col = 0; col < heights[0].length; col++) {
            // System.out.println("Pacific Ocean.");
            dfs(heights, 0, col, pacific);
            // System.out.println("Atlantic Ocean.");
            dfs(heights, heights.length - 1, col, atlantic);
        } // for
        for (int row = 0; row < heights.length; row++) {
            // System.out.println("Pacific Ocean.");
            dfs(heights, row, 0, pacific);
            // System.out.println("Atlantic Ocean.");
            dfs(heights, row, heights[0].length - 1, atlantic);
        }
        pacific.retainAll(atlantic);

        // for (List<Integer> p : pacific) {
        //     System.out.println(p.get(0) + " " + p.get(1));
        // } // for

        return new ArrayList<>(pacific);
    } // pacificAtlantic

    private void dfs(int[][] grid, int row, int col, Set<List<Integer>> curr) {
        // System.out.println("Okay: " + row + " " + col + " " + curr.size());
        List<Integer> temp = new ArrayList<>();
        temp.add(row);
        temp.add(col);

        if (curr.contains(temp)) return;

        curr.add(temp);

        for (int[] d : dirs) {
            int nRow = row + d[0], nCol = col + d[1];

            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length) {
                if (grid[nRow][nCol] >= grid[row][col]) {
                    int t = grid[row][col];
                    grid[row][col] = -1;
                    dfs(grid, nRow, nCol, curr);
                    grid[row][col] = t;
                } // if
            } // if
        } // for
    } // dfs
} // Solution