class MinStack {

    Deque<Long> st;
    Deque<Long> minst;

    public MinStack() {
        st = new ArrayDeque<>();
        minst = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push((long) val);
        if(minst.isEmpty() || minst.peek().intValue() >= val) minst.push((long) val);
    }
    
    public void pop() {
        long x = st.pop();
        if(!minst.isEmpty() && minst.peek()==x) minst.pop();
    }
    
    public int top() {
        return st.peek().intValue();
    }
    
    public int getMin() {
        return minst.peek().intValue();
    }
}
