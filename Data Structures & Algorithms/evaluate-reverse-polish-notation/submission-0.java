class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> st = new ArrayDeque<>();
        int curr;
        for(String x : tokens) {
            switch (x) {
                case "+" :
                    curr = (Integer.parseInt(st.pop()) + Integer.parseInt(st.pop()));
                    st.push(String.valueOf(curr));
                    break;
                
                case "-" :
                    curr = ((-1)*Integer.parseInt(st.pop()) + Integer.parseInt(st.pop()));
                    st.push(String.valueOf(curr));
                    break;
                
                case "*" :
                    curr = (Integer.parseInt(st.pop()) * Integer.parseInt(st.pop()));
                    st.push(String.valueOf(curr));
                    break;
                
                case "/" :
                    int a = Integer.parseInt(st.pop());
                    int b = Integer.parseInt(st.pop());
                    curr = b/a;
                    st.push(String.valueOf(curr));
                    break;
                
                default :
                    st.push(x);
            }
        }
        return Integer.parseInt(st.pop());
    }
}
