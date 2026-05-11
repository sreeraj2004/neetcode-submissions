class Solution {
    private static final int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] == '1'){
                    helper(grid , r, c);
                    count++;
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid, int r , int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        for(int[] d : dir){
            helper(grid,r+d[0],c+d[1]);
        }
    }
}
