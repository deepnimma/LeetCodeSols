class MinStack {
    Stack<Integer> s;
    Stack<Integer> min;
    int currMin;

    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
        currMin = Integer.MAX_VALUE;
    } // minStack
    
    public void push(int val) {
        s.push(val);

        if (val <= currMin) {
            min.push(currMin);
            currMin = val;
        } // if
    } // push
    
    public void pop() {
        int popped = s.pop();
        if (currMin == popped) {
            currMin = min.pop();
        } // if
    } // pop
    
    public int top() {
        return s.peek();
    } // top
    
    public int getMin() {
        return currMin;
    } // getMin
} // MinStack

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */