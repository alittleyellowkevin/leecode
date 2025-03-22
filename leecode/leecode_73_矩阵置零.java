package leecode;

public class leecode_73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        boolean flagCol = false;
        boolean flagVol = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                flagCol = true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0){
                flagVol = true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0){
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if(flagCol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if(flagVol){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
