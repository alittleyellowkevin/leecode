package huawei;

import java.util.Scanner;

public class HJ75_公共子串计算 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String a = in.nextLine().trim();
        String b = in.nextLine().trim();

        // res[i][j] 最大后缀子串 标识 a[0-i] 与 b[0-j]的后缀多少字母相同
        int[][] res = new int[a.length() + 1][b.length() + 1];

        int count = 0;
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                char c1 = a.charAt(i - 1);
                char c2 = b.charAt(j - 1);
                if (c1 == c2) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                    count = Math.max(count, res[i][j]);
                } else {
                    res[i][j] = 0;
                }
            }
        }
        System.out.println(count);
    }
}
