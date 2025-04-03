package huawei;

import java.util.Scanner;

public class HJ17_坐标移动 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine().trim();
            String[] strs = line.split(";");
            int x = 0;
            int y = 0;
            for (String str : strs) {
                if (str.matches("[ADWS][0-9]{1,2}")) {
                    char c = str.charAt(0);
                    int num = Integer.parseInt(str.substring(1));
                    if (c == 'A') {
                        x -= num;
                    } else if (c == 'D') {
                        x += num;
                    } else if (c == 'W') {
                        y += num;
                    } else if (c == 'S') {
                        y -= num;
                    }
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
