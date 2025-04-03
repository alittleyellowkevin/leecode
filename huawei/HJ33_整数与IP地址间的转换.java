package huawei;

import java.util.Scanner;

public class HJ33_整数与IP地址间的转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case

            String ipString = in.nextLine().trim();
            Long number = in.nextLong();

            // 处理 IP 地址
            String[] numbers = ipString.split("\\.");
            int res = 0;
            for (int i = 0; i < numbers.length; i++) {
                res |= Integer.valueOf(numbers[i]);
                if (i != 3) {
                    res = res << 8;
                }
            }
            // 处理数字
            String resString = "";
            for (int i = 0; i < 4; i++) {
                int b = 255;
                b &= number >> ((3 - i) * 8);
                resString += String.valueOf(b) + '.';
            }

            System.out.println(res);
            System.out.println(resString.substring(0, resString.length() - 1));
        }
    }
}
