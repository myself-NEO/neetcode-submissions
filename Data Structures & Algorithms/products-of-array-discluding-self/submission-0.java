class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lpro = new int[n];
        int[] rpro = new int[n];
        lpro[0] = nums[0];
        rpro[n-1] = nums[n-1];

        for(int i=1; i<n; i++) lpro[i] = lpro[i-1]*nums[i];
        for(int i=n-2; i>=0; i--) rpro[i] = rpro[i+1]*nums[i];

        int[] ans = new int[n];
        ans[0] = rpro[1];
        ans[n-1] = lpro[n-2];
        for(int i=1; i<n-1; i++) ans[i] = lpro[i-1]*rpro[i+1];

        return ans;
    }
}  
