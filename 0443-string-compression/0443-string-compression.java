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
                int start = writer;

                while (currCnt > 0) {
                    chars[writer++] = (char) ((currCnt % 10) + '0');
                    currCnt /= 10;
                } // while

                cnt += (writer - start) + 1;
                int l = start;
                int r = writer - 1;

                while (l < r) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                    l++;
                    r--;
                } // while
            } else cnt++;

            i = j;

            // System.out.println(Arrays.toString(chars));
        } // while

        return cnt;
    } // compress
} // Solution