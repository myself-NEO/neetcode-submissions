class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        for(int[] x : points) {
            pq.add(new Pair(x[0]*x[0] + x[1]*x[1], x));
        }

        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll().getValue();
        }

        return ans;

    }
}
