class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList()).add(edge[0]);
        }

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(int i=0; i<n; i++) {
            int[] currHeight = new int[]{i, 0};
            bfs(graph, i, pq, currHeight, n);
            pq.offer(currHeight);
        }
        int minHeight = pq.peek()[1];
        while(!pq.isEmpty() && pq.peek()[1]==minHeight) {
            int[] c = pq.poll();
            ans.add(c[0]);
        }
        return ans;
    }

    private void bfs(Map<Integer, List<Integer>> graph, int node, PriorityQueue<int[]> pq, int[] currHeight, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        boolean[] visited = new boolean[n];
        visited[node] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            currHeight[1]++;

            for(int i=0; i<size; i++) {
                int curr = q.poll();
                List<Integer> nbrs = graph.getOrDefault(curr, new ArrayList<>());
                if(nbrs.size()==0) return;
                for(int nbr : nbrs) {
                    if(!visited[nbr]) {
                        visited[nbr] = true;
                        q.offer(nbr);
                    }
                }
            }
        }
    }
}