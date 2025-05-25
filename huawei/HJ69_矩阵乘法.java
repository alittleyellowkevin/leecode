package huawei;

import java.util.Scanner;

public class HJ69_矩阵乘法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] matrix1 = new int[m][n];
        int[][] matrix2 = new int[n][k];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                matrix2[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                int res = 0;
                for (int z = 0; z < n; z++) {
                    res += matrix1[i][z] * matrix2[z][j];
                }
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

}
