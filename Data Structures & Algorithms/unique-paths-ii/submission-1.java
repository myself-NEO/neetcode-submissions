class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int flagi=-1, flagj=-1;
        for(int i=0; i<m; i++){
            if(obstacleGrid[i][0]==1){
                flagi = i;
                break;
            }
        }

        if(flagi==-1) flagi = m;

        for(int i=0; i<flagi; i++){
            dp[i][0] = 1;
        }

        for(int j=0; j<n; j++){
            if(obstacleGrid[0][j]==1){
                flagj = j;
                break;
            }
        }

        if(flagj==-1) flagj=n;

        for(int j=0; j<flagj; j++){
            dp[0][j] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}