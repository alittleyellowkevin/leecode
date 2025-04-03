package huawei;

import java.util.Scanner;

public class HJ21_简单密码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'a' && c <= 'c') {
                    result.append('2');
                } else if (c >= 'd' && c <= 'f') {
                    result.append('3');
                } else if (c >= 'g' && c <= 'i') {
                    result.append('4');
                } else if (c >= 'j' && c <= 'l') {
                    result.append('5');
                } else if (c >= 'm' && c <= 'o') {
                    result.append('6');
                } else if (c >= 'p' && c <= 's') {
                    result.append('7');
                } else if (c >= 't' && c <= 'v') {
                    result.append('8');
                } else if (c >= 'w' && c <= 'z') {
                    result.append('9');
                } else if (c >= 'A' && c < 'Z') {
                    result.append((char) (c + 33));
                } else if (c == 'Z') {
                    result.append('a');
                } else {
                    result.append(c);
                }
            }
            System.out.println(result.toString());
        }
    }

}