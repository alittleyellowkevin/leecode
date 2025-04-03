package huawei;

import java.util.Scanner;

public class HJ32_密码截取 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine().trim();
            int res = 1;
            for (int i = 0; i < str.length(); i++) {
                // 第一种方式 从该点向两边
                int count = 1;
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                    left--;
                    right++;
                    count += 2;
                }
                res = Math.max(res, count);

                // 第二种方式：从此点以及下一个点开始
                count = 0;
                left = i;
                right = i + 1;
                while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                    left--;
                    right++;
                    count += 2;
                }
                res = Math.max(res, count);
            }
            System.out.println(res);
        }
    }

}
