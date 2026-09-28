class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for(int i=0; i<t.length(); i++) tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        int l=0, required = tmap.size(), got=0;
        Map<Character, Integer> window = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int bestL = 0;
        for(int r=0; r<s.length(); r++) {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            if(tmap.containsKey(s.charAt(r)) && tmap.get(s.charAt(r)).equals(window.get(s.charAt(r)))) got++;
            while(required==got) {
                if(ans > r-l+1) {
                    bestL = l;
                    ans = r-l+1;
                }
                char toBeDeleted = s.charAt(l);
                window.put(toBeDeleted, window.get(toBeDeleted) - 1);
                if(tmap.containsKey(toBeDeleted) && tmap.get(toBeDeleted)>window.get(toBeDeleted)) got--;
                l++;
            }
        }
        return ans==Integer.MAX_VALUE ? "" : s.substring(bestL, bestL+ans);
    }
}
