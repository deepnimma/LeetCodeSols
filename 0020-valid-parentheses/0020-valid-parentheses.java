class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> hold = new Stack<>();
        char[] c = s.toCharArray();

        for (char i : c) {
            if (i == '(' || i == '[' || i == '{') {
                hold.push(i);
            } else if (i == ']') {
                if (hold.empty() || hold.pop() != '[') return false;
            } else if (i == ')') {
                if (hold.empty() || hold.pop() != '(') return false;
            } else if (i == '}') {
                if (hold.empty() || hold.pop() != '{') return false;
            } // if
        } // for

        return hold.empty();
    } // isValid
} // Solution