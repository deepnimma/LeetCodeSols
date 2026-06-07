class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();

        for (String op : operations) {
            System.out.println(op + " " + scores.size());
            char first = op.charAt(0);
            if (first == '+') {
                int a = scores.pop();
                int b = scores.peek();
                scores.push(a);
                scores.push(a + b);
            } else if (first == 'D') {
                scores.push(scores.peek() * 2);
            } else if (first == 'C') {
                scores.pop();
            } else {
                scores.push(Integer.valueOf(op));
            } // if-else
        } // for

        int sum = 0;
        while (!scores.isEmpty()) sum += scores.pop();

        return sum;
    } // calPoints
} // Solution