class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix[0].length - 1);
    } // searchMatrix

    private boolean search(int[][] matrix, int target, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return false;

        if (target == matrix[row][col]) return true;
        else if (target > matrix[row][col]) return search(matrix, target, row + 1, col);
        else return search(matrix, target, row, col - 1);
    } // search
} // Solution