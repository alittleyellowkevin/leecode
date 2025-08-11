package hotcode100;

import java.util.ArrayList;
import java.util.List;

public class leecode_54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        result.add(matrix[i][j]);
        while (result.size() < (matrix.length * matrix[0].length)){
            while (j+1<matrix[0].length && matrix[i][j+1] != 101){
                matrix[i][j] = 101;
                j++;
                result.add(matrix[i][j]);
            }
            while (i+1<matrix.length && matrix[i+1][j] != 101){
                matrix[i][j] = 101;
                i++;
                result.add(matrix[i][j]);
            }
            while (j-1>=0 && matrix[i][j-1] != 101){
                matrix[i][j] = 101;
                j--;
                result.add(matrix[i][j]);
            }
            while (i-1>=0 && matrix[i-1][j] != 101){
                matrix[i][j] = 101;
                i--;
                result.add(matrix[i][j]);
            }
        }
        return result;
    }
}
