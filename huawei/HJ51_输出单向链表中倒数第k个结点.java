package huawei;

import java.util.Scanner;
import java.util.*;

public class HJ51_输出单向链表中倒数第k个结点 {
    // 定义链表节点
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            int last = in.nextInt();
            System.out.println(list.get(n - last));
        }
    }
}