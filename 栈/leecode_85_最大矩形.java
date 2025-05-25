package 栈;

public class leecode_85_最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        int[][] numberMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (j > 0) {
                        numberMatrix[i][j] = numberMatrix[i][j - 1] + 1;
                    } else {
                        numberMatrix[i][j] = 1;
                    }
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int minLen = numberMatrix[i][j];// 最小宽度
                maxArea = Math.max(minLen, maxArea);// 最大面积
                int k = i;
                while (k >= 0) {
                    minLen = Math.min(minLen, numberMatrix[k][j]);// 更新最小宽度
                    maxArea = Math.max(maxArea, minLen * (i - k + 1));// 更新最大面积
                    k--;
                }
            }
        }
        return maxArea;
    }
}
