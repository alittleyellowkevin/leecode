package huawei;

import java.util.Scanner;

public class HJ15_求int型正整数在内容中存储1的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int count = 0;
            for (int i = 0; i < 32; i++) {
                count += (a >> i & 1) == 1 ? 1 : 0;
            }
            System.out.println(count);
        }
    }
}