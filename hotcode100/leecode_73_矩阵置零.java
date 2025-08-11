package hotcode100;

public class leecode_73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        // 首先找到一个0，利用其所在行所在列去判断是否设置为0
        int[] fristZeroPosition = new int[2];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    fristZeroPosition[0] = i;
                    fristZeroPosition[1] = j;
                }
            }
        }

        if(matrix[fristZeroPosition[0]][fristZeroPosition[1]]!=0){
            return;
        }

        // 再根据行列去找0
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[fristZeroPosition[0]][j] = 0;
                    matrix[i][fristZeroPosition[1]] = 0;
                }
            }
        }

        // 最后覆盖所有
        //从行开始
        for(int i=0; i<matrix.length; i++){
            if(i!=fristZeroPosition[0] && matrix[i][fristZeroPosition[1]] == 0){
                for(int j=0; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        //从列开始
        for(int i=0; i<matrix[0].length; i++){
            if(i != fristZeroPosition[1] && matrix[fristZeroPosition[0]][i] == 0){
                for(int j=0; j<matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        //最后将此行此列设置为0
        for(int i=0; i<matrix.length; i++){
            matrix[i][fristZeroPosition[1]] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[fristZeroPosition[0]][i] = 0;
        }


    }
}
