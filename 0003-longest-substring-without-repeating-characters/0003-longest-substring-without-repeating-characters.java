class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int maxLen = 0;
        Set<Character> seen = new HashSet<>();

        while (j < n) {
            while (seen.contains(s.charAt(j))) {
                seen.remove(s.charAt(i));
                i++;
            } // while

            seen.add(s.charAt(j));
            j++;
            maxLen = Math.max(maxLen, j - i);
        } // while

        return maxLen;
    } // lengthOfLongestSubstring
} // Solution