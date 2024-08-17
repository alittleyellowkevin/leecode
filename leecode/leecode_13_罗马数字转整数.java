package leecode;

import java.util.HashMap;
import java.util.Map;

public class leecode_13_罗马数字转整数 {
    public static void main(String[] args) {
        String s = "123456";
        System.out.println(s.substring(2,3));
    }
    public int romanToInt(String s) {
        int num = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        for (int i = 0; i < s.length(); i++) {
            if(i+1<s.length() && map.containsKey(s.substring(i, i+2))){
                num += map.get(s.substring(i, i+2));
                i++;
            }else {
                num += map.get(s.substring(i, i+1));
            }
        }
        return num;
    }
}
