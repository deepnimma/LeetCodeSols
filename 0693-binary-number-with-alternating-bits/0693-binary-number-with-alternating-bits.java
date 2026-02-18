class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n == 0 || n == 1) return true;
        int lastBit = n % 2;
        n >>= 1;

        while (n > 0) {
            if (n % 2 == lastBit) return false;
            lastBit = n % 2;
            n >>= 1;
        } // while

        return true;
    } // hasAlternatingBits
} // Solution