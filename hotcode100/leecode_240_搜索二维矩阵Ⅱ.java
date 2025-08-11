package hotcode100;

public class leecode_240_搜索二维矩阵Ⅱ {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length-1;
        while (true){
            if(target > matrix[row][column]){
                if(row + 1 >= matrix.length){
                    return false;
                }else {
                    row++;
                }
            } else if (target < matrix[row][column]) {
                if(column-1 < 0){
                    return false;
                }else {
                    column--;
                }
            }else {
                return true;
            }
        }
    }
}
