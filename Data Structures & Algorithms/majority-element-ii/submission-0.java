class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0)+1);
        int cutoff = nums.length/3;
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > cutoff) ans.add(e.getKey());
        }
        return ans;
    }
}