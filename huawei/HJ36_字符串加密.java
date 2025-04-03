package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ36_字符串加密 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine();
            char[] res = in.nextLine().trim().toCharArray();
            Set<Character> set = new HashSet<>();
            String newabString = "";
            for (int i = 0; i < line.length(); i++) {
                if (!set.contains(line.charAt(i))) {
                    set.add(line.charAt(i));
                    newabString += line.charAt(i);
                }
            }
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                if (!set.contains(c)) {
                    newabString += c;
                }
            }

            HashMap<Character, Character> hashMap = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                hashMap.put(c, newabString.charAt(i));
            }

            for (int i = 0; i < res.length; i++) {
                res[i] = hashMap.get(res[i]);
            }

            System.out.println(String.valueOf(res));
        }
    }
}
