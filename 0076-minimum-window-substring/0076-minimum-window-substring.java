class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || s.length() < t.length()) return new String();

        int[] map = new int[128];
        int cnt = t.length();
        int i = 0, j = 0, minLen = Integer.MAX_VALUE;
        int solIndex = 0;

        char[] ct = t.toCharArray();
        for (char c : ct) map[c]++;

        char[] cs = s.toCharArray();

        while (j < cs.length) {
            if (map[cs[j++]]-- > 0) {
                cnt--;
            } // if

            while (cnt == 0) {
                if (j - i < minLen) {
                    solIndex = i;
                    minLen = j - i;
                } // if

                if (map[cs[i++]]++ == 0) {
                    cnt++;
                } // if
            } // while
        } // while

        return minLen == Integer.MAX_VALUE ? new String() : new String(cs, solIndex, minLen);
    } // minWindow
} // Solution