class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        int rows=grid.length, cols=grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j]==1 && !visited[i][j]) {
                    int[] area = new int[1];
                    dfs(grid, area, i, j, rows, cols, visited);
                    ans = Math.max(ans, area[0]);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int[] area, int i, int j, int r, int c, boolean[][] visited) {
        if(i<0 || i>= r || j<0 || j>=c) return;
        if(visited[i][j] || grid[i][j]==0) return;

        visited[i][j] = true;
        area[0]++;

        dfs(grid, area, i+1, j, r, c, visited);
        dfs(grid, area, i-1, j, r, c, visited);
        dfs(grid, area, i, j+1, r, c, visited);
        dfs(grid, area, i, j-1, r, c, visited);
    }

}
