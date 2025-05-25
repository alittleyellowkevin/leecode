package huawei;

import java.util.Scanner;

public class HJ96_表示数字 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取输入字符串
        String str = in.nextLine();

        // 处理字符串，将数字用*号包围
        String result = processString(str);

        // 输出结果
        System.out.println(result);
    }

    /**
     * 将字符串中的数字用*号包围起来
     * 
     * @param str 输入字符串
     * @return 处理后的字符串
     */
    private static String processString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        boolean inDigit = false; // 标记当前是否在数字序列中

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                // 如果是数字，且不在数字序列中，添加前导*
                if (!inDigit) {
                    result.append('*');
                    inDigit = true;
                }
                result.append(c);
            } else {
                // 如果不是数字，且在数字序列中，添加后导*
                if (inDigit) {
                    result.append('*');
                    inDigit = false;
                }
                result.append(c);
            }
        }

        // 如果字符串以数字结尾，添加后导*
        if (inDigit) {
            result.append('*');
        }

        return result.toString();
    }
}