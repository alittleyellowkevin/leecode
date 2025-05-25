package huawei;

import java.util.HashMap;
import java.util.Scanner;

public class HJ81_字符串字符匹配 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine().trim();
        String line2 = in.nextLine().trim();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < line1.length(); i++) {
            char c = line1.charAt(i);
            map.put(c, 1);
        }

        for (int i = 0; i < line2.length(); i++) {
            char c = line2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (Integer value : map.values()) {
            if (value > 0) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
