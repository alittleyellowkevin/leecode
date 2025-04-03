
package huawei;

import java.util.Scanner;

public class HJ1_字符串最后一个单词长度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String[] strs = a.split(" ");
            System.out.print(strs[strs.length - 1].length());
        }
    }
}