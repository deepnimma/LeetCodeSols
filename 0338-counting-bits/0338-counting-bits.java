class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < n + 1; i++) ans[i] = count(i);

        return ans;
    } // countBits

    private int count(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n >>= 1;
        } // while

        return cnt;
    } // count
} // Solution