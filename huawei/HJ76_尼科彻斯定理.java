package huawei;

import java.util.Scanner;

public class HJ76_尼科彻斯定理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }
        int begin = 1;
        for (int i = 1; i < n; i++) {
            begin += 2 * i;
        }
        for (int i = 1; i < n; i++) {
            System.out.print(begin + "+");
            begin += 2;
        }
        System.out.print(begin);
    }
}
