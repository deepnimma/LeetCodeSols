class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minVal = Integer.MAX_VALUE;
        int negCnt = 0;

        for (int[] row : matrix) {
            for (int val : row) {
                sum += Math.abs(val);
                if (val < 0) negCnt++;
                minVal = Math.min(minVal, Math.abs(val));
            } // for
        } // for

        if (negCnt % 2 != 0) sum -= 2 * minVal;

        return sum;
    } // maxMatrixSum
} // Solution