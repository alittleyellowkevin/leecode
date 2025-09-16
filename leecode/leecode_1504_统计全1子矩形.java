package leecode;

public class leecode_1504_统计全1子矩形 {
    public int numSubmat(int[][] mat) {
        // 预处理
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1 && j != 0){
                    mat[i][j] += mat[i][j-1];
                }
            }
        }

        int sum = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] != 0){
                    int minLeft = mat[i][j];
                    for(int k=i; k>=0; k--){
                        minLeft = Math.min(minLeft, mat[k][j]);
                        sum += minLeft;
                    }
                }
            }
        }
        return sum;
    }
}
