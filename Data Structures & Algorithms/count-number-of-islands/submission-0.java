class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j]=='1' & !visited[i][j]) {
                    ans++;
                    dfs(grid, i, j, visited, rows, cols);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited, int r, int c) {
        if(i<0 || i>=r || j<0 || j>=c) return;
        if(visited[i][j] || grid[i][j]=='0') return;

        visited[i][j] = true;

        dfs(grid, i-1, j, visited, r, c);  //up
        dfs(grid, i, j+1, visited, r, c);  //right
        dfs(grid, i+1, j, visited, r, c);  // down
        dfs(grid, i, j-1, visited, r, c);  // left
    }
}
