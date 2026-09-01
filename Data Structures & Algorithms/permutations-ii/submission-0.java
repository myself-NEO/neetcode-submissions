class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        bt(nums, ans, new ArrayList<>(), visited);
        return ans;
    }

    private void bt(int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] visited) {
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(i > 0 && !visited[i-1] && nums[i]==nums[i-1]) continue;
            if(visited[i]) continue;
            int num = nums[i];
            curr.add(num);
            visited[i] = true;
            bt(nums, ans, curr, visited);
            visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}