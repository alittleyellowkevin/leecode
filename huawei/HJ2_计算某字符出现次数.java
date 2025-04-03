package huawei;

import java.util.Scanner;

public class HJ2_计算某字符出现次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine().toLowerCase();
            String b = in.nextLine().toLowerCase();
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(0)) {
                    count++;
                }
            }
            System.out.print(count);
        }
    }
}
