package huawei;

import java.util.Scanner;

public class HJ20_密码验证合格程序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String password = in.nextLine().trim();
            String result = "OK";
            // 判断密码长度是否小于等于8
            if (password.length() <= 8) {
                result = "NG";
            }
            // 判断是否包含 大写字母，小写字母，数字，特殊符号三种
            int count = 0;
            if (password.matches(".*[a-z].*")) {
                count++;
            }
            if (password.matches(".*[A-Z].*")) {
                count++;
            }
            if (password.matches(".*[0-9].*")) {
                count++;
            }
            if (password.matches(".*[\\W].*")) {
                count++;
            }
            if (count < 3) {
                result = "NG";
            }
            // 判断是否有重合字符串
            for (int i = 0; i < password.length(); i++) {
                for (int j = i + 3; j + 3 < password.length(); j++) {
                    if (password.substring(i, i + 3).equals(password.substring(j, j + 3))) {
                        result = "NG";
                    }
                }
            }
            System.out.println(result);
        }
    }

}