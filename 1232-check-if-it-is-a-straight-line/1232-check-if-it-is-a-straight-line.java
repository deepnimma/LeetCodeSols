class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
        int deltaY = yDiff(coordinates[1], coordinates[0]);
        int deltaX = xDiff(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
            if (deltaY * xDiff(coordinates[i], coordinates[0]) != deltaX * yDiff(coordinates[i], coordinates[0])) return false;
        } // for

        return true;
    } // checkStraightLine

    int yDiff(int[] a, int[] b) {
        return a[1] - b[1];
    } // yDiff

    int xDiff(int[] a, int[] b) {
        return a[0] - b[0];
    } // xDiff
} // Solution