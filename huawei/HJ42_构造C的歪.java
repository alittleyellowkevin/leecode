package huawei;

import java.util.Scanner;

public class HJ42_构造C的歪 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int c = a > b ? a + a - b : b + b - a;
            System.out.println(c);
        }
    }
}
