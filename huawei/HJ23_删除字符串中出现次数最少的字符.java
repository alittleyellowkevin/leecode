package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HJ23_删除字符串中出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String result = removeLeastFrequentChars(str);
            System.out.println(result);
        }
    }

    private static String removeLeastFrequentChars(String str) {
        // TODO: 实现删除出现次数最少的字符的逻辑
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        List<Character> minChar = new ArrayList<>();
        for (Character key : map.keySet()) {
            if (minCount > map.get(key)) {
                minChar.clear();
                minChar.add(key);
                minCount = map.get(key);
            } else if (minCount == map.get(key)) {
                minChar.add(key);
            }
        }

        for (char c : minChar) {
            str = str.replace(String.valueOf(c), "");
        }

        return str;
    }
}