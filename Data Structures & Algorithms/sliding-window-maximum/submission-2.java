class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        int n = nums.length;
        for(int i=0; i<Math.min(n,k); i++) pq.offer(new int[]{i, nums[i]});
        if(n <= k) return new int[]{pq.poll()[1]};
        int[] ans = new int[n-k+1];
        ans[0] = pq.peek()[1];
        for(int i=k; i<n; i++) {
            while(!pq.isEmpty() && pq.peek()[0] <= i-k) pq.poll();
            pq.offer(new int[]{i, nums[i]});
            ans[i-k+1] = pq.peek()[1];
        }
        return ans;
    }
}
