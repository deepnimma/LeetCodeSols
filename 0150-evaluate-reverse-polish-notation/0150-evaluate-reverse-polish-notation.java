class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (String s : tokens) {
            try {
                int num = Integer.parseInt(s);
                numbers.push(num);
            } catch (NumberFormatException  nfe) {
                int b = numbers.pop();
                int a = numbers.pop();
                if (s.equals("+")) {
                    numbers.push(a + b);
                } else if (s.equals("-")) {
                    numbers.push(a - b);
                } else if (s.equals("*")) {
                    numbers.push(a * b);
                } else if (s.equals("/")) {
                    numbers.push(a / b);
                } // 
            } // try-catch
        } // for

        return numbers.pop();
    } // evalRPN
} // Solution