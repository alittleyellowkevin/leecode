package ACM;

import java.util.Scanner;

public class meituan_2024_2_小美的平衡矩阵 {
    public static void main(String[] args) {
        //初始化
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }

        // 用number[i][j] 标识 长为i，宽为 j 的矩阵含有多少个1
        for (int i = 1; i < n; i++) {
            array[0][i] = array[0][i - 1] + array[0][i];
        }
        for (int i = 1; i < n; i++) {
            array[i][0] = array[i - 1][0] + array[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i][j] + array[i - 1][j] + array[i][j - 1] - array[i - 1][j -
                        1];
            }
        }

        //开始计算每种类型的有多少个
        for (int i = 1; i <= n; i++) {
            int count = 0;
            if (i % 2 == 1) {
                System.out.println(0);
            } else {
                for (int l = -1; l < n - i; l++) {
                    int l2 = l + i;
                    for (int r = -1; r < n - i; r++) {
                        int r2 = r + i;
                        int oneSize = i * i / 2;
                        if (oneSize == (array[l2][r2] - (l < 0 ? 0 : array[l][r2]) - (r < 0 ? 0 :
                                array[l2][r]) + (l < 0 || r < 0 ? 0 : array[l][r])))
                            count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
