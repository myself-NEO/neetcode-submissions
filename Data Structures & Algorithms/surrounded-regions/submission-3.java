class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int j=0; j<cols; j++) {
            if(board[0][j]=='O' && !visited[0][j]) {
                visited[0][j] = true;
                dfs(board, 0, j, rows, cols, visited, dirs, false);
            }
        }
        for(int j=0; j<cols; j++) {
            if(board[rows-1][j]=='O' && !visited[rows-1][j]) {
                visited[rows-1][j] = true;
                dfs(board, rows-1, j, rows, cols, visited, dirs, false);
            }
        }
        for(int i=0; i<rows; i++) {
            if(board[i][0]=='O' && !visited[i][0]) {
                visited[i][0] = true;
                dfs(board, i, 0, rows, cols, visited, dirs, false);
            }
        }
        for(int i=0; i<rows; i++) {
            if(board[i][cols-1]=='O' && !visited[i][cols-1]) {
                visited[i][cols-1] = true;
                dfs(board, i, cols-1, rows, cols, visited, dirs, false);
            }
        }

        for(int i=1; i<rows-1; i++) {
            for(int j=1; j<cols-1; j++) {
                if(board[i][j]=='O' && !visited[i][j]) {
                    visited[i][j] = true;
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int rows, int cols, boolean[][] visited, int[][] dirs, boolean flag) {
        if(flag) board[i][j] = 'X';
        for(int[] dir : dirs) {
            int dr = i + dir[0];
            int dc = j + dir[1];
            if(dr>=0 && dr<rows && dc>=0 && dc<cols && !visited[dr][dc]) {
                if(board[dr][dc]=='O') {
                    visited[dr][dc] = true;
                    if(flag) board[dr][dc] = 'X';
                    dfs(board, dr, dc, rows, cols, visited, dirs, flag);
                }
            }
        }
    }
}
