package search;

public class leecode_74_搜索二维数组 {
    //暴力解法
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    //二分法
    public boolean searchMatrix2(int[][] matrix, int target) {
        int hang = matrix.length;  //3
        int lie = matrix[0].length; //4
        int l = 0;
        int r = hang * lie -1;
        while (l<=r){
            int mid = (l+r)/2;
            if(matrix[mid/lie][mid%lie] > target){
                r = mid-1;
            } else if (matrix[mid/lie][mid%lie] < target) {
                l = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }
}
