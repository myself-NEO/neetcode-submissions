class Solution {
    public int findJudge(int n, int[][] trust) {
        List<ArrayList<Integer>> graph = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for(int[] x : trust) {
            graph.get(x[0]).add(x[1]);
        }
        List<Integer> possibleJudge = new ArrayList<>();
        for(int i=1; i<graph.size(); i++) {
            if(graph.get(i).size()==0) possibleJudge.add(i);
        }

        for(int x : possibleJudge) {
            boolean flag = false;
            for(int i=1; i<graph.size(); i++) {
                if(i==x) continue;
                if(!graph.get(i).contains(x)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return x;
        }

        return -1;
    }
}