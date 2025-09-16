package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_498_对角线遍历 {
    public static int[] up = {-1, 1};
    public static int[] down = {1, -1};
    public static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2},
                {3, 4},
        };
        int[] diagonalOrder = findDiagonalOrder(mat);
        for (int i : diagonalOrder) {
            System.out.print(i + " ");
        }
    }
    public static int[] findDiagonalOrder(int[][] mat) {
        goUp(mat, 0, 0);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void goUp(int[][] mat, int row, int vol){
        result.add(mat[row][vol]);
        // 如果是在最后一格则直接返回
        if(row == (mat.length-1) && vol == (mat[0].length-1)){
            return;
        }
        // 如果在最后一列，则往下并转换方向
        if(vol == (mat[0].length-1)){
            goDown(mat, row+1, vol);
            return;
        }
        // 如果在第一行，则往右并转换方向
        if(row == 0){
            goDown(mat, row, vol+1);
            return;
        }
        goUp(mat, row + up[0], vol + up[1]);
    }

    public static void goDown(int[][] mat, int row, int vol){
        result.add(mat[row][vol]);
        // 如果是在最后一格则直接返回
        if(row == (mat.length-1) && vol == (mat[0].length-1)){
            return;
        }
        // 如果在最后一行，则往右并转换方向
        if(row == (mat.length-1)){
            goUp(mat, row, vol+1);
            return;
        }
        // 如果在第一列，则往下并转换方向
        if(vol == 0){
            goUp(mat, row+1, vol);
            return;
        }
        goDown(mat, row + down[0], vol + down[1]);
    }


    public int[] findDiagonalOrder1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }
}
