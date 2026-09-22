class Solution {
    public int longestConsecutive(int[] nums) {
        // dp[i] = longest sequence ending at i;
        // dp[i] = Max(dp[i], dp[j]+1) where nums[j]=nums[i]+1;
        // dp[0] = 1

        // This is the solution if "The elements have to be consecutive in the original array."
        // int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // int ans = 1;
        // for(int i=1; i<n; i++) {
        //     for(int j=0; j<i; j++) {
        //         if(nums[i] == nums[j]+1) {
        //             dp[i] = Math.max(dp[i], dp[j]+1);
        //             ans = Math.max(ans, dp[i]);
        //         }
        //     }
        // }
        // return ans;

        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);

        int curr=1, ans=1;
        for(int x : nums) {
            if(!set.contains(x-1)){
                int t=1;
                while(set.contains(x+t)) {
                    curr++;
                    t++;
                }
                ans = Math.max(ans, curr);
                curr = 1;
            }
        }
        return ans;
    }
}
