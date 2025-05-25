package huawei;

import java.util.Scanner;

public class HJ106_字符逆序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        // 将字符串转为字符数组并逆序输出
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }
}
