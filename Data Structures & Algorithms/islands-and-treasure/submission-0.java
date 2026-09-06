class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int INF = 2147483647;
        bfs(grid, INF, dirs);
    }

    private void bfs(int[][] grid, int INF, int[][] dirs) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j]==0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int d = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            d++;
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int dr = curr[0] + dir[0];
                    int dc = curr[1] + dir[1];
                    if(dr>=0 && dr<rows && dc>=0 && dc<cols) {
                        if(grid[dr][dc]==INF) {
                            grid[dr][dc] = d;
                            q.offer(new int[]{dr, dc});
                        } else if(grid[dr][dc]==-1) {
                            continue;
                        }
                    }
                }
            }
        }
    }
}
