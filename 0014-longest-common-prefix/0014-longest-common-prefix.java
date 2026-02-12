class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        for (int i = strs[0].length(); i >= 1; i--) {
            boolean outside = false;
            String sub = strs[0].substring(0, i);

            for (String s : strs) {
                if (!s.startsWith(sub)) {
                    outside = true;
                    break;
                }
            } // for

            if (outside) continue;
            return sub;
        } // for

        return "";
    } // longestCommonPrefix
} // Solution