class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        bt(nums, ans, new ArrayList<>(), visited);
        return ans;
    }

    private void bt(int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] visited) {
        if(curr.size()==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            curr.add(nums[i]);
            bt(nums, ans, curr, visited);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}
