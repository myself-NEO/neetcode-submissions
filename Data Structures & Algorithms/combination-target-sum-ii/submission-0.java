class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        bt(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void bt(int[] nums, int target, List<List<Integer>> ans, List<Integer> curr, int start) {
        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0) return;
        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            bt(nums, target-nums[i], ans, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
