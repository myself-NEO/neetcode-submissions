class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree is a graph that is connected and has no cycle.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] x : edges) {
            graph.computeIfAbsent(x[0], k -> new ArrayList<>()).add(x[1]);
            graph.computeIfAbsent(x[1], k -> new ArrayList<>()).add(x[0]);
        }

        Set<Integer> visited = new HashSet<>();

        // check if cycle is present
        if(dfsCycle(0, -1, graph, visited)) return false;

        // check if its connected
        return visited.size() == n;
    }

    private boolean dfsCycle(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for(int x : graph.getOrDefault(node, new ArrayList<>())) {
            if(!visited.contains(x)) {
                if(dfsCycle(x, node, graph, visited)) return true;
            }else if (x != parent) return true;
        }
        return false;
    }
}
