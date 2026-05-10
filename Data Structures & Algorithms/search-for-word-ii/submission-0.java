class Solution {
    private int rows;
    private int cols;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];

        for (String word : words) {
            boolean found = false;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    // Start DFS for 'word' at (r, c)
                    if (helper(board, word, r, c, 0)) {
                        res.add(word);
                        found = true;
                        break; // Stop searching for this word once found
                    }
                }
                if (found) break; // Break outer loop as well
            }
        }
        return res;
    }

    public boolean helper(char[][] board, String word, int r, int c, int idx) {
        // If we reached the end of the word, we found it!
        if (idx == word.length()) return true;
        
        // Bounds check, character match check, and visited check
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(idx) || visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        
        // Explore all 4 directions
        boolean res = helper(board, word, r + 1, c, idx + 1) ||
                      helper(board, word, r - 1, c, idx + 1) || 
                      helper(board, word, r, c + 1, idx + 1) ||
                      helper(board, word, r, c - 1, idx + 1);
                      
        visited[r][c] = false; // Backtrack
        
        return res; 
    }
}