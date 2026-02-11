class Solution {
    public int reverseBits(int n) {
        int ret = 0, power = 31;

        while (n != 0) {
            ret += (n & 1) << power;
            System.out.println(n + " " + (n >>> 1));
            n = n >>> 1;
            power -= 1;
        } // while

        return ret;
    } // reverseBits
} // Solution