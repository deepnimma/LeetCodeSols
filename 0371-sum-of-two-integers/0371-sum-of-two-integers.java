class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int ans = a ^ b;
            int car = (a & b) << 1;
            a = ans;
            b = car;
        } // while

        return a;
    } // getSum
} // Solution