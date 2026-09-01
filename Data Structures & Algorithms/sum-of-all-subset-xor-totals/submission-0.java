class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, ans, new ArrayList<>(), 0);
        int sum = 0;
        for(List<Integer> x : ans) {
            int temp = 0;
            for(int y : x) temp ^= y;
            sum += temp;
        }
        return sum;
    }

    private void bt(int[] nums, List<List<Integer>> ans, List<Integer> curr, int start) {
        ans.add(new ArrayList<>(curr));

        for(int i=start; i<nums.length; i++) {
            curr.add(nums[i]);
            bt(nums, ans, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}