package leecode;

import java.util.HashMap;
import java.util.Map;

public class leecode_12_整数转罗马数字 {
    public static void main(String[] args) {
        intToRoman(3749);
    }
    public static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        while (num != 0){
            for (int i = 0; i < ints.length; i++) {
                if(num >= ints[i]){
                    num -= ints[i];
                    sb.append(strings[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
