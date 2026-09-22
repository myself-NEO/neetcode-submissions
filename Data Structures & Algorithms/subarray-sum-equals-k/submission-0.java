class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) preSum[i+1] = preSum[i] + nums[i];
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : preSum) {
            if(map.containsKey(x-k)) {
                ans += map.get(x-k);
            }
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        return ans;
    }
}