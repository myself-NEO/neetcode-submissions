class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char x : s.toCharArray()) freq[x-'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        for(int i=0; i<26; i++) {
            if(freq[i]>0) pq.offer(new int[]{i, freq[i]});
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            char currx = (char) (curr[0]+'a');
            if(ans.length()>0 && ans.charAt(ans.length()-1)==currx) {
                if(!pq.isEmpty()){
                    int[] nextcurr = pq.poll();
                    char y = (char) (nextcurr[0]+'a');
                    ans.append(y);
                    if(nextcurr[1]>1) pq.offer(new int[]{nextcurr[0], nextcurr[1]-1});
                    pq.offer(curr);
                }
            }else {
                ans.append(currx);
                if(curr[1]>1) pq.offer(new int[]{curr[0], curr[1]-1});
            }
        }
        System.out.println(ans.toString());
        return ans.length()==s.length() ? ans.toString() : "";
    }
}