class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        // state: dp[i] = min cost to reach ith step
        // recurrence: dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        // base case: dp[0] = 0, dp[1] = 0, dp[2]=cost[2]

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=n; i++) dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        return dp[n];
    }
}
