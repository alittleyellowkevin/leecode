package huawei;

import java.util.Scanner;

public class HJ91_走方格的方案数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] res = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < m + 1; i++) {
            res[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }

        System.out.println(res[n][m]);
    }
}