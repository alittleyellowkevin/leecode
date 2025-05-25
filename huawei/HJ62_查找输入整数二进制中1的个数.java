package huawei;

import java.util.Scanner;

public class HJ62_查找输入整数二进制中1的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(count1(a));
        System.out.println(count1(b));
    }

    private static int count1(int a) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += 1 & (a >> i);
        }
        return count;
    }

}
