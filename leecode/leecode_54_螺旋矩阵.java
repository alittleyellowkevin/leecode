package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_54_螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        matrix[0][0] = 101;
        right(matrix, 0, 1, list);
        return list;
    }

    private static void right(int[][] matrix, int l, int r, List<Integer> list) {
        if(r<matrix[0].length && matrix[l][r] != 101){
            list.add(matrix[l][r]);
            matrix[l][r] = 101;
            right(matrix, l, r+1, list);
        }else {
            down(matrix, l+1, r-1, list);
        }
    }

    private static void down(int[][] matrix, int l, int r, List<Integer> list) {
        if(l<matrix.length && matrix[l][r] != 101){
            list.add(matrix[l][r]);
            matrix[l][r] = 101;
            down(matrix, l+1, r, list);
        }else {
            left(matrix, l-1, r-1, list);
        }
    }

    private static void left(int[][] matrix, int l, int r, List<Integer> list) {
        if(l>=0 && matrix[l][r] != 101){
            list.add(matrix[l][r]);
            matrix[l][r] = 101;
            left(matrix, l, r-1, list);
        }else {
            up(matrix, l+1, r+1, list);
        }
    }

    private static void up(int[][] matrix, int l, int r, List<Integer> list) {
        if(list.size() == matrix.length * matrix[0].length)return;
        if(r>=0 && matrix[l][r] != 101){
            list.add(matrix[l][r]);
            matrix[l][r] = 101;
            up(matrix, l+1, r, list);
        }else {
            right(matrix, l-1, r+1, list);
        }
    }

}
