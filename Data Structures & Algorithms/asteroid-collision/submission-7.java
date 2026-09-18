class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int x : asteroids) {
            boolean alive = true;
            while(!st.isEmpty() && st.peek() > 0 && alive && x < 0) {
                if(st.peek() < -x) {
                    st.pop();
                    continue;
                }
                if(st.peek() + x == 0) st.pop();
                alive = false;
            }
            if(alive) st.push(x);
        }

        int n = st.size();
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) ans[i] = st.pop();
        return ans;
    }
}