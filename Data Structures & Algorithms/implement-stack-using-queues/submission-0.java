class MyStack {

    Deque<Integer> q;
    Deque<Integer> st;

    public MyStack() {
        this.q = new ArrayDeque<>();
        this.st = new ArrayDeque<>();
        
    }
    
    public void push(int x) {
        q.offer(x);
        while(!st.isEmpty()) q.offer(st.poll());
        Deque<Integer> temp = st;
        st = q;
        q = temp;
    }
    
    public int pop() {
        return st.poll();
    }
    
    public int top() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */