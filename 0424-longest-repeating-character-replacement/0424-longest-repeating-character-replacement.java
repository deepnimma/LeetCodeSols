class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        int i = 0, maxCnt = 0, maxLen = 0;
        for (int j = 0; j < n; j++) {
            maxCnt = Math.max(maxCnt, ++cnt[s.charAt(j) - 'A']);
            while (j - i + 1 - maxCnt > k) {
                cnt[s.charAt(i) - 'A']--;
                i++;
            } // while

            maxLen = Math.max(maxLen, j - i + 1);
        } // for

        return maxLen;
    } // characterReplacement
} // Solution