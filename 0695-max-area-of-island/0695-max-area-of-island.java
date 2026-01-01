class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j, 0), maxArea);
                } // if
            } // for
        } // for

        return maxArea;
    } // maxAreaOfIsland

    private int dfs(int[][] grid, int i, int j, int area) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return area;
        } // if

        grid[i][j] = -1;
        area++;

        area = Math.max(dfs(grid, i + 1, j, area), area);
        area = Math.max(dfs(grid, i - 1, j, area), area);
        area = Math.max(dfs(grid, i, j + 1, area), area);
        area = Math.max(dfs(grid, i, j - 1, area), area);

        // grid[i][j] = 1;

        return area;
    } // dfs
} // Solution