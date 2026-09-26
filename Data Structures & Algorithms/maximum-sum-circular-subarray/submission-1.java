class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] dpmax = new int[n];
        int[] dpmin = new int[n];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int ansmax = dpmax[0], ansmin = dpmin[0];
        int sum = nums[0];
        for(int i=1; i<n; i++) {
            sum += nums[i];
            dpmax[i] = Math.max(dpmax[i-1]+nums[i], nums[i]);
            dpmin[i] = Math.min(dpmin[i-1]+nums[i], nums[i]);
            ansmax = Math.max(ansmax, dpmax[i]);
            ansmin = Math.min(ansmin, dpmin[i]);
        }
        if(ansmax < 0) return ansmax;
        return Math.max(ansmax, sum-ansmin);
    }
}