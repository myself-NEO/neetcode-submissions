class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int rows = heights.length, cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if((i==0 || j==0) && !pacific[i][j]) dfs(heights, pacific, i, j, rows, cols, dirs);
                if((i==rows-1 || j==cols-1) && !atlantic[i][j]) dfs(heights, atlantic, i, j, rows, cols, dirs);
            }
        }

        for(int i=0; i<rows; i++) pacific[i][0] = true;
        for(int j=0; j<cols; j++) pacific[0][j] = true;

        for(int i=0; i<rows; i++) atlantic[i][cols-1] = true;
        for(int j=0; j<cols; j++) atlantic[rows-1][j] = true;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) ans.add(List.of(i, j));
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int rows, int cols, int[][] dirs) {
        ocean[i][j] = true;
        for(int[] dir : dirs) {
            int dr = i + dir[0];
            int dc = j + dir[1];
            if(dr>=0 && dr<rows && dc>=0 && dc<cols && !ocean[dr][dc]) {
                if(heights[dr][dc] >= heights[i][j]) dfs(heights, ocean, dr, dc, rows, cols, dirs);
            }
        }
    }
}
