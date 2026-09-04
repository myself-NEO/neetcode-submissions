class Solution {
    public int rob(int[] nums) {
        // state definition: dp[i] : max money robbed till ith house
        // recurrence: dp[i] = math.max(dp[i-1, nums[i]+dp[i-2]])
        // base case: dp[0] = 0, dp[1] = nums[0];

        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=n; i++) dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        return dp[n];
    }
}
