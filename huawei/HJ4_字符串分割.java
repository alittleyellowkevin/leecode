package huawei;

import java.util.Scanner;

public class HJ4_字符串分割 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            int count = 8;
            while (count < a.length()) {
                System.out.println(a.substring(count - 8, count));
                count += 8;
            }
            while (a.length() % 8 != 0) {
                a = a + "0";
            }
            System.out.println(a.substring(count - 8, count));
        }
    }
}
