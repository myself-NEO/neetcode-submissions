class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int l=0, r=numbers.length-1;
        while(r < numbers.length) {
            if(numbers[l]+numbers[r]==target) return new int[] {l+1, r+1};
            else if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return ans;
    }
}
