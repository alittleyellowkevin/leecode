package huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HJ64_MP3光标位置 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = Integer.valueOf(in.nextLine());
            String s = in.next();

            int now = 1;
            int front = 1;
            int back = n >= 4 ? 4 : n;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'U') {
                    if (now != front) {
                        now--;
                    } else if (now == front && now != 1) {
                        now--;
                        front--;
                        back--;
                    } else {
                        now = n;
                        front = n - 3 <= 0 ? 1 : n - 3;
                        back = n;
                    }
                } else {
                    if (now != back) {
                        now++;
                    } else if (now == back && now != n) {
                        now++;
                        front++;
                        back++;
                    } else {
                        now = 1;
                        front = 1;
                        back = n >= 4 ? 4 : n;
                    }
                }
            }
            for (int i = front; i <= back; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println(now);
        }

    }
}
