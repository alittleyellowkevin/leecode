package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9_提取不重复的整数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String number = in.nextLine();
            String result = "";
            Set<Character> set = new HashSet();
            for (int i = number.length() - 1; i >= 0; i--) {
                if (!set.contains(number.charAt(i))) {
                    set.add(number.charAt(i));
                    result += number.charAt(i);
                }
            }
            System.out.println(result);
        }
    }
}
