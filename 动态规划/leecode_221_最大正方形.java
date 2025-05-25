package 动态规划;

public class leecode_221_最大正方形 {
    public int maximalSquare(char[][] matrix) {
        // count[i][j]标识以 i j为右下角最大正方形
        int[][] count = new int[matrix.length][matrix[0].length];
        int countMax = 0; // 最大正方形边长

        // 初始化
        for (int i = 0; i < matrix.length; i++) {
            count[i][0] = (matrix[i][0] - '0');
            countMax = Math.max(countMax, count[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            count[0][i] = (matrix[0][i] - '0');
            countMax = Math.max(countMax, count[0][i]);
        }

        // 循环遍历
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // 当左上，左，上均大于当前数且当前数为1时
                int left = count[i][j - 1];
                int up = count[i - 1][j];
                int leftUp = count[i - 1][j - 1];
                if (matrix[i][j] == '1' && left >= 1 && up >= 1 && leftUp >= 1) {
                    count[i][j] = Math.min(Math.min(left, up), leftUp) + 1;
                    countMax = Math.max(countMax, count[i][j]);
                } else if (matrix[i][j] == '1') {
                    count[i][j] = 1;
                }
            }
        }
        return countMax * countMax;
    }
}
