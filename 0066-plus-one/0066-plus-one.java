class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] ans = new int[n];
        boolean carry = false;

        if (digits[n - 1] == 9) {
            ans[n - 1] = 0;
            carry = true;
        } else ans[n - 1] = digits[n - 1] + 1;

        for (int i = n - 2; i >= 0; i--) {
            int digSum = digits[i];
            if (carry) {
                digSum++;
                carry = false;
            } // if

            if (digSum >= 10) {
                digSum %= 10;
                carry = true;
            } // if

            ans[i] = digSum;
        } // for

        if (carry) {
            int[] aans = new int[n + 1];
            for (int i = 0; i < ans.length; i++) {
                aans[i + 1] = ans[i];
            } // for
            aans[0] = 1;

            ans = aans;
        } // if

        return ans;
    } // plusOne
} // Solution