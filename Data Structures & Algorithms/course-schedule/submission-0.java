class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Directed graph, we have to find if its cyclic

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : prerequisites) graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);

        int[] state = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(state[i]==0) {
                if(dfsDirectedCycle(graph, state, i)) return false;
            }
        }

        return true;
    }

    private boolean dfsDirectedCycle(Map<Integer, List<Integer>> graph, int[] state, int node) {
        state[node] = 1;
        for(int nbr : graph.getOrDefault(node, new ArrayList<>())) {
            if(state[nbr]==1) return true;
            if(state[nbr]==0) {
                if(dfsDirectedCycle(graph, state, nbr)) return true;
            }
        }
        state[node] = 2;
        return false;
    }
}
