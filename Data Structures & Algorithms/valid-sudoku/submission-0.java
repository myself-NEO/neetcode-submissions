class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(!validrows(board)) return false;
        if(!validcols(board)) return false;
        for(int i=0; i<9; i+=3) {
            for(int j=0; j<9; j+=3) {
                if(!validsq(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean validrows(char[][] b) {
        for(int i=0; i<9; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=0; j<9; j++){
                char x = b[i][j];
                if(x == '.') continue;
                if(set.contains(x) || x > '9' || x < '1') return false;
                set.add(x);
            }
        }
        return true;
    }

    private boolean validcols(char[][] b) {
        for(int i=0; i<9; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=0; j<9; j++){
                char x = b[j][i];
                if(x == '.') continue;
                if(set.contains(x) || x > '9' || x < '1') return false;
                set.add(x);
            }
        }
        return true;
    }

    private boolean validsq(char[][] b, int m, int n) {
        Set<Character> set = new HashSet<>();
        for(int i=m; i<m+3; i++){
            for(int j=n; j<n+3; j++) {
                char x = b[i][j];
                if(x == '.') continue;
                if(set.contains(x) || x > '9' || x < '1') return false;
                set.add(x);
            }
        }
        return true;
    }
}
