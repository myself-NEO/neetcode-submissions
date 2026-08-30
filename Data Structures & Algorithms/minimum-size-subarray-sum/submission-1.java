class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for(int i=1; i<=n; i++) preSum[i] = preSum[i-1] + nums[i-1];

        int l=0, ans=Integer.MAX_VALUE;
        for(int r=0; r<n; r++) {
            while(preSum[r+1]-preSum[l]>=target) {
                ans = Math.min(ans, r-l+1);
                l++;
            }

        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}