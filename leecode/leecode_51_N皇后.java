package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_51_N皇后 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<String> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        boolean[][] flag = new boolean[n][n];
        solveN(result, 0, flag);
        return result;
    }

    private static void solveN(List<List<String>> result, int i, boolean[][] flag) {
        if(i == flag.length){
            List<String> list = new ArrayList<>();
            for (int j = 0; j < flag.length; j++) {
                StringBuffer sb = new StringBuffer();
                for (int k = 0; k < flag.length; k++) {
                    if(flag[j][k]){
                        sb.append('Q');
                    }else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }else {
            for (int j = 0; j < flag.length; j++) {
                if(putAble(flag, i, j)){
                    flag[i][j] = true;
                    solveN( result, i+1, flag);
                    flag[i][j] = false;
                }
            }
        }
    }

    private static boolean putAble(boolean[][] flag, int i, int j) {
        for (int k = 0; k < flag.length; k++) {
            if (flag[i][k]) {
                return false;
            }
        }
        for (int k = 0; k < flag.length; k++) {
            if (flag[k][j]) {
                return false;
            }
        }
        int k = 0;
        int l = 0;
        while (k<flag.length && l<flag.length){
            if (flag[k][l]) {
                return false;
            }
            k++;
            l++;
        }
        k = 0;
        l = flag.length-1;
        while (k<flag.length && l<flag.length){
            if (flag[k][l]) {
                return false;
            }
            k++;
            l--;
        }
        return true;
    }


}
