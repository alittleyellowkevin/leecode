package huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HJ92_在字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int maxSize = 0;
        String resultString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = 1;
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    count++;
                }
                if (maxSize < count) {
                    maxSize = count;
                    resultString = s.substring(i + 1 - count, i + 1);
                } else if (maxSize == count) {
                    resultString += s.substring(i + 1 - count, i + 1);
                }
            }
        }
        System.out.println(resultString + "," + maxSize);
    }

}