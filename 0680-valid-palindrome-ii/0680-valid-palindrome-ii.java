class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                String a = s.substring(i, j);
                String b = s.substring(i + 1, j + 1);

                return check(a) || check(b);
            } // if

            i++;
            j--;
        } // while

        return true;
    } // validPalindrome

    private boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } // if
            i++;
            j--;
        } // while
        
        return true;
    } // checkPalindrome
} // Solution