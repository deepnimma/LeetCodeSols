class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] cnt = new int[26];

        if (cs.length != ct.length) return false;

        for (char c : cs) {
            cnt[c - 'a']++;
        } // for

        for (char c : ct) {
            cnt[c - 'a']--;
        } // for

        for (int i : cnt) {
            if (i != 0) return false;
        } // for

        return true;
    } // isAnagram
} // Solution