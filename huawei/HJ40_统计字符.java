package huawei;

import java.util.Scanner;

public class HJ40_统计字符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int[] counts = countCharacters(str);

            // 输出统计结果
            for (int count : counts) {
                System.out.println(count);
            }
        }
    }

    private static int[] countCharacters(String str) {
        // TODO: 实现字符统计逻辑
        // 返回数组依次为：英文字符、空格、数字、其他字符
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                a++;
            } else if (Character.isDigit(str.charAt(i))) {
                b++;
            } else if (str.charAt(i) == ' ') {
                c++;
            } else {
                d++;
            }
        }
        return new int[] { a, c, b, d };
    }
}