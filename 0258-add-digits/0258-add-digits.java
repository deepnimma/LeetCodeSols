class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int digiSum = 0;
            while (num > 0) {
                digiSum += num % 10;
                num /= 10;
            } // while
            num = digiSum;
        } // while

        return num;
    } // addDigits
} // Solution