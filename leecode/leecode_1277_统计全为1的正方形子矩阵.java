package leecode;

public class leecode_1277_统计全为1的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        // 预处理
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 1 && j != 0){
                    matrix[i][j] += matrix[i][j-1];
                }
            }
        }

        int sum = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] != 0){
                    int minLeft = matrix[i][j];
                    for(int k=i; k>=0; k--){
                        int gap = i - k + 1;
                        minLeft = Math.min(minLeft, matrix[k][j]);
                        if(minLeft >= gap){
                            sum += 1;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
