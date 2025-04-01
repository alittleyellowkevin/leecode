package dynamic;

public class leecode_63_不同路径Ⅱ {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0]==1){
            return 0;
        }

        // 1. num[i][j]表示到达当前点的最大路径种类
        int[][] res = new int[m][n];

        // 2.初始化将第一行与第一列设置为1,如果在第一行或列中有被遮挡的则将其后面的元素都设置为0
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0]==1){
                res[i][0] = 0;
            }else{
                if(i>0 && res[i-1][0] == 0){
                    res[i][0] =0;
                }else{
                    res[i][0] =1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i]==1){
                res[0][i] = 0;
            }else{
                if(i>0 && res[0][i-1] == 0){
                    res[0][i] =0;
                }else{
                    res[0][i] =1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 3. 递推公式：由于num[i][j]可以由num[i-1][j]和num[i][j-1]组合成
                if(obstacleGrid[i][j]==1){
                    res[i][j] = 0;
                }else{
                    res[i][j] = res[i][j-1] + res[i-1][j];
                }
            }
        }
        return res[m-1][n-1];
    }
}
