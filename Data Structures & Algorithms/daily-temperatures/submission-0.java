class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            int curr = temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()] < curr) {
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}
