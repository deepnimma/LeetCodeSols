class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        int i = 0;
        int j = c.length - 1;

        while (i < j) {
            if (c[i] != c[j]) return false;
            i++;
            j--;
        } // while

        return true;
    } // isPalindrome
} // Solution