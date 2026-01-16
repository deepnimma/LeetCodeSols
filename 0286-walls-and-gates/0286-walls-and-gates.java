class Solution {
    List<int[]> dirs = Arrays.asList(
        new int[] {1, 0},
        new int[] {0, 1},
        new int[] {0, -1},
        new int[] {-1, 0}
    );

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    q.add(new int[] {row, col});
                } // if
            } // for
        } // for

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];

            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != Integer.MAX_VALUE) {
                    continue;
                } // if

                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] {r, c});
            } // for
        } // while
    } // wallsAndGates
} // Solution