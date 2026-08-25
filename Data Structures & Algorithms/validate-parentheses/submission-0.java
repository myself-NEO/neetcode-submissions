class Solution {
    public boolean isValid(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') st.push(i);
            else {
                if(st.isEmpty()) return false;
                if(
                    (s.charAt(st.peek())=='(' && s.charAt(i) != ')') || 
                    (s.charAt(st.peek())=='{' && s.charAt(i) != '}') || 
                    (s.charAt(st.peek())=='[' && s.charAt(i) != ']')
                ) return false;
                else st.poll();
            }
        }
        return st.isEmpty();
    }
}
