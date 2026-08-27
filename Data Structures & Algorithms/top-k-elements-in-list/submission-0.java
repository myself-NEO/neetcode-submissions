class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(new int[]{e.getValue(), e.getKey()});
            if(pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++) ans[i] = pq.poll()[1];
        return ans;
    }
}
