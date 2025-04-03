package huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HJ14_字符串排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            String nu = in.nextLine();
            List<String> strList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strList.add(in.nextLine().trim());
            }
            strList.sort((a, b) -> a.compareTo(b));
            for (String s : strList) {
                System.out.println(s);
            }
        }
    }
}