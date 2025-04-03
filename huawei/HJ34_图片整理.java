package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ34_图片整理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            char[] line = in.nextLine().toCharArray();
            Arrays.sort(line);
            System.out.println(String.valueOf(line));
        }
    }
}
