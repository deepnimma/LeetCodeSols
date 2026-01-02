class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        char[] c = s.toCharArray();

        for (int i = 1; i < c.length; i++) {
            int diff = (c[i] - 'a') - (c[i - 1] - 'a');
            sum += Math.abs(diff);
        } // for

        return sum;
    } // scoreOfString
} // Solution