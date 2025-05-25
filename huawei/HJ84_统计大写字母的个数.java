package huawei;

import java.util.Scanner;

public class HJ84_统计大写字母的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                count++;
            }
        }
        System.out.println(count);
    }
}
