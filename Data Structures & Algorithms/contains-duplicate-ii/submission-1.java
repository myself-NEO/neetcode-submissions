class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0 || nums.length < 2) return false;
        Deque<Integer> q = new ArrayDeque<>(k+1);
        for(int i=0; i<=k; i++) {
            if(q.contains(nums[i])) return true;
            q.offer(nums[i]);
        }
        for(int i=k+1; i<nums.length; i++) {
            q.poll();
            if(q.contains(nums[i])) return true;
            q.offer(nums[i]);
        }
        return false;
    }
}