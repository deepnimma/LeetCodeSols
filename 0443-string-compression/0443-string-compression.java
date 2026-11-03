class Solution {
    public int compress(char[] chars) {
        int cnt = 0;
        int i = 0;
        int j = 0;
        int writer = 0;

        while (j < chars.length) {
            int currCnt = 0;
            while (j < chars.length && chars[i] == chars[j]) {
                currCnt++;
                j++;
            } // while
            
            chars[writer++] = chars[i];

            if (currCnt > 1) {
                String digs = new String();

                while (currCnt > 0) {
                    digs += Integer.toString(currCnt % 10);
                    currCnt /= 10;
                } // while

                cnt += digs.length() + 1;

                for (int k = digs.length() - 1; k >= 0; k--) {
                    chars[writer++] = digs.charAt(k);
                } // for
            } else cnt++;

            i = j;

            // System.out.println(Arrays.toString(chars));
        } // while

        return cnt;
    } // compress
} // Solution