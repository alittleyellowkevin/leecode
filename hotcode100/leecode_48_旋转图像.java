package hotcode100;

public class leecode_48_旋转图像 {
    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
    public static void rotate(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;

        // 斜交换
        for (int i = 0; i < matrix.length ; i++) {
            for(int j = matrix.length-i-1; j>=0; j--){
                int temp  = matrix[i][j];
                matrix[i][j] = matrix[columnSize-j-1][rowSize-i-1];
                matrix[columnSize-j-1][rowSize-i-1] = temp;
            }
        }

        //上下交换
        for(int i=0; i<rowSize/2; i++){
            for(int j=0; j<columnSize; j++){
                int temp  = matrix[i][j];
                matrix[i][j] = matrix[rowSize-i-1][j];
                matrix[rowSize-i-1][j] = temp;
            }
        }
    }
}
