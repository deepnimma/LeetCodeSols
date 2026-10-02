class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sc = t.toCharArray();
        char[] tc = s.toCharArray();

        int i = 0, j = 0;

        while (i < sc.length && j < tc.length) {
            if (sc[i] == tc[j]) j++;
            i++;
        } // while

        return j == tc.length;
    } // isSubsequence
} // Solution