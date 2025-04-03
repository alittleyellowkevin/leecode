package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ26_字符串排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            char[] strArray = in.nextLine().trim().toCharArray();

            Map<Character, String> treemap = new TreeMap<>();

            for (int i = 0; i < strArray.length; i++) {
                char c = strArray[i];
                if (Character.isAlphabetic(c)) {
                    char key = Character.toLowerCase(strArray[i]);
                    treemap.put(key, treemap.getOrDefault(key, "") + c);
                }
            }
            int index = 0;
            for (Character key : treemap.keySet()) {
                String begin = treemap.get(key);
                for (int i = 0; i < begin.length(); i++) {
                    // 当其不是字母时不断将index+1直到改str[index]为字母
                    while (!Character.isAlphabetic(strArray[index])) {
                        index++;
                    }
                    strArray[index] = begin.charAt(i);
                    index++;
                }
            }
            System.out.println(String.valueOf(strArray));
        }
    }
}
