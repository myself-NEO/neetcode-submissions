class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // shortest path -> weighed (>=0) & single source

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times) {
            graph.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if(d > dist[node]) continue;

            for(int[] nbrw : graph.getOrDefault(node, new ArrayList<>())) {
                int nbr = nbrw[0], w = nbrw[1];
                if(dist[nbr] > dist[node]+w) {
                    dist[nbr] = dist[node]+w;
                    pq.offer(new int[]{nbr, dist[nbr]});
                }
            }
        }

        int ans = -1;
        for(int x : dist) {
            if(x==Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
