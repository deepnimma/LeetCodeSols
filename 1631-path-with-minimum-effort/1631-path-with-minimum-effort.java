class Solution {
    int[][] dirs = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int[][] diffMatrix = new int[row][col];

        for (int[] eachRow : diffMatrix) Arrays.fill(eachRow, Integer.MAX_VALUE);

        diffMatrix[0][0] = 0;
        Queue<Cell> queue = new PriorityQueue<>((a, b) -> a.diff.compareTo(b.diff));
        boolean[][] visited = new boolean[row][col];
        queue.add(new Cell(0, 0, diffMatrix[0][0]));

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            visited[curr.x][curr.y] = true;
            if (curr.x == row - 1 && curr.y == col - 1) return curr.diff;
            for (int[] dir : dirs) {
                int adjX = curr.x + dir[0];
                int adjY = curr.y + dir[1];

                if (isValidCell(adjX, adjY, row, col) && !visited[adjX][adjY]) {
                    int currDiff = Math.abs(heights[adjX][adjY] - heights[curr.x][curr.y]);
                    int maxDiff = Math.max(currDiff, diffMatrix[curr.x][curr.y]);

                    if (diffMatrix[adjX][adjY] > maxDiff) {
                        diffMatrix[adjX][adjY] = maxDiff;
                        queue.add(new Cell(adjX, adjY, maxDiff));
                    } // if
                } // if
            } // for
        } // while

        return diffMatrix[row - 1][col - 1];
    } // minimumEffortPath

    boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x <= row - 1 && y <= col - 1;
    } // isValidCell

    class Cell {
        int x;
        int y;
        Integer diff;

        Cell(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        } // Cell
    } // Cell
} // Solution