package huawei;

import java.util.Scanner;

public class HJ7_取近似数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextFloat()) { // 注意 while 处理多个 case
            float a = in.nextFloat();
            float b = a - (int) a;
            if (b >= 0.5) {
                System.out.println((int) a + 1);
            } else {
                System.out.println((int) a);
            }
        }
    }

}
