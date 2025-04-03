package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ31_单词倒排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            str = str.replaceAll("[\\W]+", " ");
            String[] strings = str.split(" ");
            for (int i = strings.length - 1; i >= 0; i--) {
                System.out.print(strings[i] + " ");
            }
        }
    }

}
