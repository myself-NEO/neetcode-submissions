class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void bt(int[] nums, int target, List<List<Integer>> ans, List<Integer> curr, int start) {
        int sum = curr.stream().mapToInt(Integer::intValue).sum();
        if(sum==target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target) return;
        for(int i=start; i<nums.length; i++) {
            curr.add(nums[i]);
            bt(nums, target, ans, curr, i);
            curr.remove(curr.size()-1);
        }
    }
}
