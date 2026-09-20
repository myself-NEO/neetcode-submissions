class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> st = new ArrayDeque<>();
        for(String x : arr) {
            if(x.length()==0) continue;
            else if (x.equals(".")) {
                continue;
            } else if (x.equals("..")) {
                if(!st.isEmpty()) st.pop();
            } else {
                st.push(x);
            }
        }

        StringBuilder ans = new StringBuilder();
        if(st.isEmpty()) return "/";

        while(!st.isEmpty()) {
            ans.append("/");
            ans.append(st.pollLast());   
        }

        return ans.toString();

    }
}