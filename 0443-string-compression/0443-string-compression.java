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
                int rev = j - 1;
                Stack<Integer> digs = new Stack<>();

                while (currCnt > 0 && rev > i) {
                    int dig = currCnt % 10;
                    currCnt /= 10;
                    digs.push(dig);
                } // while

                cnt += digs.size() + 1;

                while (!digs.isEmpty()) {
                    chars[writer] = (char) (digs.pop() + '0');
                    writer++;
                } // while
            } else cnt++;

            i = j;

            // System.out.println(Arrays.toString(chars));
        } // while

        return cnt;
    } // compress
} // Solution