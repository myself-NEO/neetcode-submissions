class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Set<String> cycleEdge = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[edges.length + 1];
        visited[1] = true;

        // as the graph is connected, so we can run just 1 dfs and it will visit all nodes
        dfs(graph, visited, 1, -1, cycleEdge);

        int[] ans = new int[2];
        for(int[] edge : edges) {
            String s = edge[0] + "," + edge[1];
            if(cycleEdge.contains(s)){
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
        }

        return ans;
    }

    // -1 means no cycle
    private int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node, int parent, Set<String> cycleEdge) {
        visited[node] = true;
        for(int nbr : graph.getOrDefault(node, new ArrayList<>())) {
            if(!visited[nbr]) {
                int ancestor = dfs(graph, visited, nbr, node, cycleEdge);
                if(ancestor != -1) {
                    cycleEdge.add(nbr+","+node);
                    cycleEdge.add(node+","+nbr);
                    // System.out.println(nbr+","+node);
                    return node==ancestor ? -1 : ancestor;
                }
            } else if (nbr != parent) {
                cycleEdge.add(nbr+","+node);
                cycleEdge.add(node+","+nbr);
                // System.out.println(nbr+","+node);
                return nbr;
            }
        }
        return -1;
    }
}
