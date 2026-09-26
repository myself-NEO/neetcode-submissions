class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            if(i==0) dp[i][0] = grid[0][0];
            else {
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
        }
        for(int j=0; j<n; j++){
            if(j==0) continue;
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}