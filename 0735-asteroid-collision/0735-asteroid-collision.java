class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int ast : asteroids) {
            boolean flag = true;

            while (!s.isEmpty() && (s.peek() > 0 && ast < 0)) {
                if (Math.abs(s.peek()) < Math.abs(ast)) {
                    s.pop();
                    continue;
                } else if (Math.abs(s.peek()) == Math.abs(ast)) {
                    s.pop();
                } // if-else if

                flag = false;
                break;
            } // while

            if (flag) s.push(ast);
        } // for

        int[] ans = new int[s.size()];
        for (int i = ans.length - 1; i >= 0; i--) ans[i] = s.pop();

        return ans;
    } // asteroidCollision
} // Solution