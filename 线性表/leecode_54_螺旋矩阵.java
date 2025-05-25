package 线性表;

import java.util.ArrayList;
import java.util.List;

public class leecode_54_螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        right(matrix, 0, 0, res);
        return res;
    }

    private static void right(int[][] matrix, int i, int j, List<Integer> res) {
        if (j + 1 < matrix[0].length && matrix[i][j + 1] != -200) {
            res.add(matrix[i][j]);
            matrix[i][j] = -200;
            right(matrix, i, j + 1, res);
        } else {
            if ((res.size() + 1) == matrix.length * matrix[0].length) {
                res.add(matrix[i][j]);
            } else {
                down(matrix, i, j, res);
            }
        }
    }

    private static void down(int[][] matrix, int i, int j, List<Integer> res) {
        if (i + 1 < matrix.length && matrix[i + 1][j] != -200) {
            res.add(matrix[i][j]);
            matrix[i][j] = -200;
            down(matrix, i + 1, j, res);
        } else {
            if (res.size() + 1 == matrix.length * matrix[0].length) {
                res.add(matrix[i][j]);
            } else {
                left(matrix, i, j, res);
            }
        }
    }

    private static void left(int[][] matrix, int i, int j, List<Integer> res) {
        if (j - 1 >= 0 && matrix[i][j - 1] != -200) {
            res.add(matrix[i][j]);
            matrix[i][j] = -200;
            left(matrix, i, j - 1, res);
        } else {
            if (res.size() + 1 == matrix.length * matrix[0].length) {
                res.add(matrix[i][j]);
            } else {
                up(matrix, i, j, res);
            }
        }
    }

    private static void up(int[][] matrix, int i, int j, List<Integer> res) {
        if (i - 1 >= 0 && matrix[i - 1][j] != -200) {
            res.add(matrix[i][j]);
            matrix[i][j] = -200;
            up(matrix, i - 1, j, res);
        } else {
            if (res.size() + 1 == matrix.length * matrix[0].length) {
                res.add(matrix[i][j]);
            } else {
                right(matrix, i, j, res);
            }
        }
    }

}
