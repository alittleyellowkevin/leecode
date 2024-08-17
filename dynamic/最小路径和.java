package dynamic;

public class 最小路径和 {
    public static void main(String[] args) {
        int[][] numbers = {{1,3,1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(numbers);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result=0;


        if(m==1 || n == 1){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result += grid[i][j];
                }
            }
            return result;
        }



        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            res[i][0] = grid[i][0]+res[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = grid[0][i] + res[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i][j-1], res[i-1][j]) + grid[i][j];
            }
        }
        return res[m-1][n-1];
    }

}
