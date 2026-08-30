class Solution {
    public void sortColors(int[] nums) {
        int l=0, mid=0, r=nums.length-1;
        while(mid <= r) {
            if(nums[mid]==0) swap(nums, mid++, l++);
            else if(nums[mid]==1) mid++;
            else swap(nums, mid, r--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}