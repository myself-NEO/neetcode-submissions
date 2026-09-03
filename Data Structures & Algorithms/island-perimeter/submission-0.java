class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] ans = new int[1];
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++) {
                if(grid[i][j]==1) {
                    dfs(grid, ans, i, j, rows, cols, visited);
                    break;
                }
            }
        }
        return ans[0];
    }

    private void dfs(int[][] grid, int[] ans, int i, int j, int r, int c, boolean[][] visited) {
        if(i<0 || i>=r || j<0 || j>=c) return;
        if(grid[i][j]==0 || visited[i][j]) return;
        
        visited[i][j] = true;
        if(i-1<0 || grid[i-1][j]==0) ans[0]++;  // up
        if(j+1>=c || grid[i][j+1]==0) ans[0]++;  // right
        if(i+1>=r || grid[i+1][j]==0) ans[0]++;  // down
        if(j-1<0 || grid[i][j-1]==0) ans[0]++;  // left

        dfs(grid, ans, i-1, j, r, c, visited);
        dfs(grid, ans, i, j+1, r, c, visited);
        dfs(grid, ans, i+1, j, r, c, visited);
        dfs(grid, ans, i, j-1, r, c, visited);
    }
}