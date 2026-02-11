class Solution {
    public int numDecodings(String s) {
        int n = s.length() + 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < n; i++) {
            if (s.charAt(i - 1) != '0') dp[i] = dp[i - 1];
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i - 2];
        } // for

        return dp[n - 1];
    } // numDecodings
} // Solution