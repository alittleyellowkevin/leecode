package leecode;

public class leecode_74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length-1;
        while (l<=r){
            int mid = (l+r)/2;
            int c = mid / matrix[0].length;
            int v = mid % matrix[0].length;
            if(matrix[c][v] > target){
                r = mid-1;
            } else if (matrix[c][v] <target) {
                l = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }
}
