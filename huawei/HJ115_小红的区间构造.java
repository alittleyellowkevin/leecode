package huawei;

import java.util.Scanner;

public class HJ115_小红的区间构造 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long x = in.nextLong();
        long min = (n - 1) * x + 1;
        long max = (n + 1) * x - 1;
        if (k >= min && k <= max) {
            // 左边第一个取 x
            long left = x;
            // 右边则取 x + min -1
            long right = x + min - 1;
            // 如果 k - min > x - 1
            if (k - min <= x - 1) {
                left = left - (k - min);
            } else {
                left = left - (x - 1);
                right = right + (k - min - x + 1);
            }
            System.out.println(left + " " + right);
        } else {
            System.out.println(-1);
        }

    }
}