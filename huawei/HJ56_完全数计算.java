package huawei;

import java.util.Scanner;

public class HJ56_完全数计算 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();

            int res = 0;
            for (int i = 1; i <= n; i++) {
                int count = 0;
                for (int j = i - 1; j >= 1; j--) {
                    if (i % j == 0) {
                        count += j;
                    }
                }
                if (count == i) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}