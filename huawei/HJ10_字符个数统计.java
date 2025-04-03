package huawei;

import java.util.Scanner;
import java.util.HashSet;

public class HJ10_字符个数统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();
            HashSet<Character> hs = new HashSet<Character>();
            for (int i = 0; i < str.length(); i++)
                hs.add(str.charAt(i));
            System.out.println(hs.size());
        }
    }
}