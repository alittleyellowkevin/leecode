package 图;

public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] board, int i, int j) {
        if((i<0 || j<0 || i>=board.length || j>=board[0].length) || board[i][j] != '1'){
            return;
        }
        board[i][j] = '#';
        dfs(board, i, j+1);
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }
}
