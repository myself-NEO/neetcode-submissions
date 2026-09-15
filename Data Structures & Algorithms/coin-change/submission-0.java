class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[a] = min coin required to get to amount a.
        // dp[a] = Min(amount to make for a & a-coin + 1)
        // dp[0] = 0

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int a=1; a<=amount; a++) {
            for(int coin : coins) {
                if(coin <= a) dp[a] = Math.min(dp[a], dp[a-coin]+1);
            }
        }

        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
