package huawei;

import java.util.Scanner;

public class HJ61_放苹果 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt(); // 苹果数
            int n = in.nextInt();// 盘子数

            System.out.println(count(m, n));
        }
    }

    private static int count(int m, int n) {
        if (m < 0 || n <= 0) {
            return 0;
        }
        if (n == 1 || m == 0 || m == 1) {
            return 1;
        }
        // 事件划分为 当存在一个盘子为空 + 无盘子为空的情况
        return count(m, n - 1) + count(m - n, n);
    }

}
