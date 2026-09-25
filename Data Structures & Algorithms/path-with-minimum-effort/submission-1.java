class Solution {
    public int minimumEffortPath(int[][] heights) {
        // minimum effort would be between 0 and Max(number);
        // we can use a binary serach for these 2 values
        int rows = heights.length, cols = heights[0].length;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++) {
                if(min > heights[i][j]) min = heights[i][j];
                if(max < heights[i][j]) max = heights[i][j];
            }
        }
        int l=0, r=max-min, ans=0;
        while(l<=r) {
            int mid = l + (r-l)/2;
            boolean[][] visited = new boolean[rows][cols];
            if(dfs(heights, 0, 0, rows, cols, visited, mid, dirs)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean dfs(int[][] heights, int r, int c, int rows, int cols, boolean[][] visited, int limit, int[][] dirs) {
        visited[r][c] = true;
        if(r==rows-1 && c==cols-1) return true;
        for(int[] dir : dirs) {
            int dr = r + dir[0];
            int dc = c + dir[1];
            if(dr>=0 && dr<rows && dc>=0 && dc<cols && !visited[dr][dc] && Math.abs(heights[dr][dc] - heights[r][c]) <= limit) {
                if(dfs(heights, dr, dc, rows, cols, visited, limit, dirs)) return true;
            }
        }
        return false;
    }
}