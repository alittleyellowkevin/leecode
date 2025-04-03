package huawei;

import java.util.Scanner;

public class HJ46_截取字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine().trim();
        int n = in.nextInt();
        System.out.println(line.substring(0, n));

    }
}