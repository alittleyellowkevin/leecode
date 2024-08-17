package backtrack;

import java.util.ArrayList;
import java.util.List;


public class N皇后 {
    public static void main(String[] args) {
        solveNQueens(4);
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        backsort(res,0, chars);
        return res;
    }

    private static void backsort(List<List<String>> res, int i, char[][] chars) {
        for (int j = 0; j < chars.length; j++) {
            if(putAble(chars, i, j)){
                if(i == chars.length-1){
                    chars[i][j] = 'Q';
                    //把这个char加入到结果中
                    List<String> array = new ArrayList<>();
                    for (int k = 0; k < chars.length; k++) {
                        array.add(new String(chars[k]));
                    }
                    res.add(array);
                    chars[i][j] = '.';
                }else {
                    chars[i][j] = 'Q';
                    backsort(res, i+1, chars);
                    chars[i][j] = '.';
                }
            }
        }
    }

    private static boolean putAble(char[][] chars, int i, int j) {
        for (int k = 0; k < chars.length; k++) {
            if(chars[i][k] == 'Q'){
                return false;
            }
        }
        for (int k = 0; k < chars.length; k++) {
            if(chars[k][j] == 'Q'){
                return false;
            }
        }
        int start_i = i;
        int start_j = j;
        while (start_j < chars.length && start_i < chars.length && start_i>=0 && start_j>=0){
            if(chars[start_i][start_j] == 'Q'){
                return false;
            }
            start_i++;
            start_j++;
        }
        start_i = i;
        start_j = j;
        while (start_j < chars.length && start_i < chars.length && start_i>=0 && start_j>=0){
            if(chars[start_i][start_j] == 'Q'){
                return false;
            }
            start_i++;
            start_j--;
        }
        start_i = i;
        start_j = j;
        while (start_j < chars.length && start_i < chars.length && start_i>=0 && start_j>=0){
            if(chars[start_i][start_j] == 'Q'){
                return false;
            }
            start_i--;
            start_j--;
        }
        start_i = i;
        start_j = j;
        while (start_j < chars.length && start_i < chars.length && start_i>=0 && start_j>=0){
            if(chars[start_i][start_j] == 'Q'){
                return false;
            }
            start_i--;
            start_j++;
        }
        return true;

    }
}
