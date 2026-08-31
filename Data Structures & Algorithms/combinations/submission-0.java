class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        // boolean[] visited = new boolean[n];
        bt(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }

    private void bt(int n, int k, List<List<Integer>> ans, List<Integer> curr, int start) {
        if(curr.size()==k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start; i<=n; i++) {
            curr.add(i);
            bt(n, k, ans, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}