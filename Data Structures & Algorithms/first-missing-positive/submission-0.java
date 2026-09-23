class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) {
            if(x <= 0) continue;
            if(x > ans) set.add(x);
            if(x==ans) ans++;
        }
        while(!set.isEmpty()) {
            if(!set.contains(ans)) return ans;
            set.remove(ans);
            ans++;
        }
        return ans;
    }
}