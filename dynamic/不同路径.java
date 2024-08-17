package dynamic;

public class 不同路径 {
    //动态规划
    public int uniquePaths(int m, int n) {

        //num[i][j]表示到达当前点的最大路径种类

        //递推公式：由于num[i][j]可以由num[i-1][j]和num[i][j-1]组合成
        // num[i][j] = num[i-1][j] + num[i][j-1]

        //初始化将第一行与第一列设置为1 因为其只有一条道路

        //打印顺序都无所谓
        if(m==1 || n == 1){
            return 1;
        }
        int[][] res = new int[m][n];

        //初始化
        for (int i = 0; i < m; i++) {
            res[i][0] =1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }

        //递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i][j-1] + res[i-1][j];
            }
        }
        return res[m-1][n-1];
    }
}
