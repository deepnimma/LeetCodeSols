class Solution {
    public boolean validPalindrome(String s) {
        return check(s, true);
    } // validPalindrome

    private boolean check(String s, boolean first) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (first) {
                    String a = s.substring(i, j);
                    String b = s.substring(i + 1, j + 1);

                    return check(a, false) || check(b, false);
                } else {
                    return false;
                } // if-else
            } // if
            i++;
            j--;
        } // while
        
        return true;
    } // checkPalindrome
} // Solution