package huawei;

import java.util.Scanner;

public class HJ5_进制转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String ox = in.nextLine();
            ox = ox.substring(2);
            int count = 0;
            for (int i = 0; i < ox.length(); i++) {
                if (Character.isDigit(ox.charAt(i))) {
                    count += (ox.charAt(i) - '0') * Math.pow(16, ox.length() - i - 1);
                } else {
                    count += ((ox.charAt(i) - 'A') + 10) * Math.pow(16, ox.length() - i - 1);
                }
            }
            System.out.println(count);
        }
    }
}
