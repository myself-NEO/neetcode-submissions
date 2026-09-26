class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(y[1], x[1]));
        if(a > 0) pq.offer(new int[]{0, a});
        if(b > 0) pq.offer(new int[]{1, b});
        if(c > 0) pq.offer(new int[]{2, c});
        StringBuilder ans = new StringBuilder();
        int ansize = 0;
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            char curr = (char) ('a' + top[0]);
            if(ansize >= 2 && ans.charAt(ansize-1)==ans.charAt(ansize-2) && ans.charAt(ansize-1)==curr) {
                if(!pq.isEmpty()) {
                    int[] stop = pq.poll();
                    char scurr = (char) ('a' + stop[0]);
                    ans.append(scurr);
                    ansize++;
                    pq.offer(top);
                    if(stop[1]>1) pq.offer(new int[]{stop[0], stop[1]-1});
                }
            } else {
                ans.append(curr);
                ansize++;
                if(top[1]>1) pq.offer(new int[]{top[0], top[1]-1});
            }
        }
        return ans.toString();
    }
}