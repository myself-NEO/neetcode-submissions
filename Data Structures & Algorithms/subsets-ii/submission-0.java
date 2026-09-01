class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void bt(int[] nums, List<List<Integer>> ans, List<Integer> curr, int start) {
        ans.add(new ArrayList<>(curr));

        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            bt(nums, ans, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
