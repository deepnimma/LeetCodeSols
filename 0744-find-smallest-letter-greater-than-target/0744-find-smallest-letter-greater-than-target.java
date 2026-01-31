class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int curr = Integer.MAX_VALUE;
        char ans = 0;

        for (char l : letters) {
            int diff = l - target;
            if (diff > 0 && diff <= curr) {
                curr = diff;
                ans = l;
            } // if
        } // for

        return ans != 0 ? ans : letters[0];
    } // nextGreatestLetter
} // Solution