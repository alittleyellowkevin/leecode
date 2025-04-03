package huawei;

import java.util.Scanner;

public class HJ29_字符串加解密 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            char[] str1 = in.nextLine().trim().toCharArray(); // 待加密的字符串
            char[] str2 = in.nextLine().trim().toCharArray(); // 待解密的字符串

            encrypt(str1);
            decrypt(str2);

            System.out.println(String.valueOf(str1));
            System.out.println(String.valueOf(str2));
        }
    }

    private static void encrypt(char[] str) {
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            // 当为字母时
            if (Character.isAlphabetic(c)) {
                if (c == 'z') {
                    str[i] = 'A';
                } else if (c == 'Z') {
                    str[i] = 'a';
                } else {
                    if (Character.isLowerCase(c)) {
                        str[i] = (char) Character.toUpperCase(c + 1);
                    } else {
                        str[i] = (char) Character.toLowerCase(c + 1);
                    }
                }
            }
            // 当为数字时
            if (Character.isDigit(c)) {
                if (c == '9') {
                    str[i] = '0';
                } else {
                    str[i] = (char) (c + 1);
                }
            }
        }
    }

    private static void decrypt(char[] str) {
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            // 当为字母时
            if (Character.isAlphabetic(c)) {
                if (c == 'a') {
                    str[i] = 'Z';
                } else if (c == 'A') {
                    str[i] = 'z';
                } else {
                    if (Character.isLowerCase(c)) {
                        str[i] = (char) Character.toUpperCase(c - 1);
                    } else {
                        str[i] = (char) Character.toLowerCase(c - 1);
                    }
                }
            }
            // 当为数字时
            if (Character.isDigit(c)) {
                if (c == '0') {
                    str[i] = '9';
                } else {
                    str[i] = (char) (c - 1);
                }
            }
        }
    }
}