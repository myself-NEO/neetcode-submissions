class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String s : operations) {
            if("C".equals(s)) st.pop();
            else if("D".equals(s)) st.push(2*st.peek());
            else if("+".equals(s)) {
                int x2 = st.pop();
                int x1 = st.pop();
                st.push(x1);
                st.push(x2);
                st.push(x1+x2);
            } else {
                st.push(Integer.valueOf(s));
            }
        }

        return st.stream().mapToInt(Integer::intValue).sum();
    }
}