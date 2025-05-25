package huawei;

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class HJ59_找出字符串中第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next().trim();

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        Character res = ' ';
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                res = key;
                break;
            }
        }

        if (res == ' ') {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }
}