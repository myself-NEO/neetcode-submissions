class Solution {
    public int rob(int[] nums) {
        int n =  nums.length;
        if(n<=1) return nums[0];
        int[] dp1 = new int[n+1]; // house 0 to n-2;
        dp1[0] = 0;
        dp1[1] = nums[0];
        int[] dp2 = new int[n+1]; // house 1 to n-1;
        dp2[0] = 0;
        dp2[1] = nums[1];

        linearrob(nums, dp1, 2, n-1, 0);
        linearrob(nums, dp2, 2, n-1, 1);

        return Math.max(dp1[n-1], dp2[n-1]);
    }

    private void linearrob(int[] nums, int[] dp, int l, int r, int offset) {
        for(int i=l; i<=r; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1+offset] );
        }
    }
}
