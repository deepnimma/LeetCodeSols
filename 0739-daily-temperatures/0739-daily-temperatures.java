class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temps = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!temps.empty() && temperatures[i] > temperatures[temps.peek()]) {
                ans[temps.peek()] = i - temps.pop();
            } // while

            temps.push(i);
        } // for

        return ans;
    } // dailyTemperatures
} // Solution