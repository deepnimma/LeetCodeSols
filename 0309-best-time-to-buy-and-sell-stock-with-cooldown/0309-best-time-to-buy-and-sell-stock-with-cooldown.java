class Solution {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int rset = 0;

        for (int pr : prices) {
            int preSold = sold;

            sold = held + pr;
            held = Math.max(held, rset - pr);
            rset = Math.max(rset, preSold);
        } // for

        return Math.max(sold, rset);
    } // maxProfit
} // Solution