class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length, cols=board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) { 
                if(board[i][j]==word.charAt(0) && !visited[i][j]) {
                    if(dfs(board, word, 0, i, j, rows, cols, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j, int r, int c, boolean[][] visited) {
        if(i<0 || i>=r || j<0 || j>=c) return false;
        if(board[i][j]!=word.charAt(idx) || visited[i][j]) return false;
        if(idx==word.length()-1) return true;

        visited[i][j] = true;

        boolean found = dfs(board, word, idx+1, i+1, j, r, c, visited) ||
        dfs(board, word, idx+1, i-1, j, r, c, visited) || 
        dfs(board, word, idx+1, i, j+1, r, c, visited) ||
        dfs(board, word, idx+1, i, j-1, r, c, visited);

        visited[i][j] = false;

        return found;
    }
}
