package array;

public class leecode_48_旋转图像 {
    public static void main(String[] args) {
        int[][] maxtrix = {{1, 2, 3}, {4, 5, 6}, {7, 8 ,9}};
        rotate(maxtrix);
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
