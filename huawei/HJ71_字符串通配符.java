package huawei;

import java.util.Scanner;

public class HJ71_字符串通配符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line1 = in.nextLine().trim();
        String line2 = in.nextLine().trim();

        // res[i][j] 标识 line [0-i] 是否能转变为 line[0-j]
        boolean[][] res = new boolean[line1.length() + 1][line2.length() + 1];

        // 初始化空字符串匹配
        res[0][0] = true;

        // 初始化 当Line2为0时 若line1 前缀为*则成立
        for (int i = 1; i < res.length; i++) {
            if (line1.charAt(i - 1) == '*') {
                res[i][0] = true;
            } else {
                break;
            }
        }

        // 循环
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                char a = line1.charAt(i - 1);
                char b = line2.charAt(j - 1);
                if (a == '*') {
                    // 当 * 为空
                    res[i][j] |= res[i - 1][j];
                    // * 不为空
                    for (int k = j; k > 0; k--) {
                        char c = line2.charAt(k - 1);
                        if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                            res[i][j] |= res[i - 1][k - 1];
                        } else {
                            break;
                        }
                    }
                } else if (a == '?') {
                    if (Character.isAlphabetic(b) || Character.isDigit(b)) {
                        res[i][j] = res[i - 1][j - 1];
                    } else {
                        res[i][j] = false;
                    }
                } else {
                    a = Character.toLowerCase(a);
                    b = Character.toLowerCase(b);
                    if (a == b) {
                        res[i][j] = res[i - 1][j - 1];
                    } else {
                        res[i][j] = false;
                    }
                }
            }
        }
        System.out.println(res[line1.length()][line2.length()]);
    }
}
