class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // directed graph -> Kahn's Algorithm to find path, if detect a cycle -> no path
        List<Integer> ans = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : prerequisites) {
            graph.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
            inDegree[edge[0]]++;
        }

        Deque<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curr = q.poll();
                ans.add(curr);
                for(int nbr : graph.getOrDefault(curr, new ArrayList<>())) {
                    inDegree[nbr]--;
                    if(inDegree[nbr]==0) q.offer(nbr);
                }
            }
        }

        return (ans.size()==numCourses) ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[0];

    }
}
