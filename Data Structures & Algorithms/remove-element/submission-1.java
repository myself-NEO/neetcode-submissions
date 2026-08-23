class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0, r=nums.length-1;
        while(l<=r) {
            while(l <= r && nums[r]==val) r--;
            if(l > r) break;
            if(nums[l]==val) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            l++;
        }
        return l;
    }
}