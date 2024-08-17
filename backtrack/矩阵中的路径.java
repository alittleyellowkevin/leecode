package backtrack;

import greedy.监控二叉树;

import java.util.List;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 'c','e'}, {'s', 'f', 'c', 's'},{ 'a', 'd', 'e', 'e'}};
        String s = "see";
        hasPath(chars, s);
    }
    public static boolean hasPath (char[][] matrix, String word) {
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == word.charAt(0)){
                    char mid = matrix[i][j];
                    matrix[i][j] = '.';
                    flag = flag || backsort(matrix, i, j, 1, word);
                    matrix[i][j] = mid;
                }
            }
        }
        return flag;
    }

    private static boolean backsort(char[][] matrix, int starti, int startj, int len, String word) {
        if (len == word.length()) {
            return true;
        } else {
            boolean flag = false;
            if (ableWalk(matrix, starti + 1, startj, len + 1, word)) {
                char mid = matrix[starti+1][startj];
                matrix[starti+1][startj] = '.';
                flag = flag || backsort(matrix, starti + 1, startj, len + 1, word);
                matrix[starti+1][startj] = mid;
            }
            if (ableWalk(matrix, starti - 1, startj, len + 1, word)) {
                char mid = matrix[starti-1][startj];
                matrix[starti-1][startj] = '.';
                flag = flag || backsort(matrix, starti - 1, startj, len + 1, word);
                matrix[starti-1][startj] = mid;
            }
            if (ableWalk(matrix, starti, startj + 1, len + 1, word)) {
                char mid = matrix[starti][startj+1];
                matrix[starti][startj+1] = '.';
                flag = flag || backsort(matrix, starti, startj + 1, len + 1, word);
                matrix[starti][startj+1] = mid;
            }
            if (ableWalk(matrix, starti, startj - 1, len + 1, word)) {
                char mid = matrix[starti][startj-1];
                matrix[starti][startj-1] = '.';
                flag = flag || backsort(matrix, starti, startj - 1, len + 1, word);
                matrix[starti][startj-1] = mid;
            }
            return flag;
        }
    }

    private static boolean ableWalk(char[][] matrix, int starti, int startj, int len, String word) {
        if(starti < matrix.length && starti>=0 && startj<matrix[0].length && startj>=0 && matrix[starti][startj] == word.charAt(len-1) ){
            return true;
        }
        return false;
    }


}
