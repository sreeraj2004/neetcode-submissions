class Solution {
    private int rows , cols;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(helper(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int r, int c, int i){
        if(i == word.length()) return true;

        if(r<0 || c<0 || r>=rows || c>=cols || board[r][c] != word.charAt(i) || visited[r][c]) 
        return false;

        visited[r][c] = true;
        boolean res = helper(board, word, r+1,c,i+1) ||
                        helper(board, word, r-1,c,i+1) ||
                        helper(board, word, r,c+1,i+1) || 
                        helper(board, word, r,c-1,i+1);
        visited[r][c] = false;
        return res; 
    }
}
