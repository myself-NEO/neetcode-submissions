class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++) {
                if(grid[i][j]==2) q.offer(new int[]{i, j});
                if(grid[i][j]==1) fresh++;
            }
        }

        if(fresh==0) return 0;

        int mins = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            mins++;
            for(int i=0; i<size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int dr = curr[0] + dir[0];
                    int dc = curr[1] + dir[1];
                    if(dr>=0 && dr<rows && dc>=0 && dc<cols) {
                        if(grid[dr][dc]==0) continue;
                        if(grid[dr][dc]==1) {
                            grid[dr][dc] = 2;
                            fresh--;
                            q.offer(new int[]{dr, dc});
                        }
                    }
                }
            }
        }

        return fresh==0 ? mins : -1;
    }
}
