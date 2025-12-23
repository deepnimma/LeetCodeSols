class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        if (cs2.length < cs1.length) return false;
        for (char c : cs1) cnt1[c - 'a']++;

        for (int i = 0; i < cs2.length; i++) {
            cnt2[cs2[i] - 'a']++;

            if (i > cs1.length - 1) {
                int cs2Index = i - cs1.length;
                cnt2[cs2[cs2Index] - 'a']--;
            } // if

            if (Arrays.equals(cnt1, cnt2)) return true;
        } // for

        return false;
    } // checkInclusion
} // Solution