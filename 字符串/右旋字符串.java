package 字符串;

import java.util.Arrays;

public class 右旋字符串 {
    public static void main(String[] args) {
        System.out.println(rightChange("abcdefg", 2));
    }
    public static String rightChange(String s, int number){
        char str[] = s.toCharArray();
        number = number % s.length();
        rev(str, 0, s.length()-1-number);
        rev(str, s.length()-number, str.length-1);
        rev(str, 0, str.length-1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    private static void rev(char[] str, int i, int j) {
        while (i<j){
            char mid = str[i];
            str[i] = str[j];
            str[j] = mid;
            i++;
            j--;
        }
    }
}
