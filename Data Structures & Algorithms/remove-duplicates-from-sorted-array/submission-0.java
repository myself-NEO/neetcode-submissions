class Solution {
    public int removeDuplicates(int[] nums) {
        int l=0, r=1, ans=1;
        while(r < nums.length) {
            if(nums[r]==nums[l]) r++;
            else {
                nums[l+1] = nums[r++];
                l++;
                ans++;
            }
        }
        return ans;
    }
}