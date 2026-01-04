class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int i : nums) sum += getSum(i);

        return sum;
    } // sumFourDivisors

    private int getSum(int n) {
        int p = (int) Math.round(Math.cbrt(n));
        if ((long) p * p * p == n && isPrime(p)) {
            return 1 + (int) Math.pow(p, 1) + (int) Math.pow(p, 2) + n;
        } // if

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int a = i;
                int b = n / i;

                if (a != b && isPrime(a) && isPrime(b)) {
                    return 1 + a + b + n;
                } // if

                return 0;
            } // if
        } // for

        return 0;
    } // getSum

    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        } // for

        return true;
    } // isPrime
} // Solution