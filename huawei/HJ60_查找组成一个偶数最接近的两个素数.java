package huawei;

import java.util.Scanner;

public class HJ60_查找组成一个偶数最接近的两个素数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int x = n / 2;
            int y = n / 2;
            while (true) {
                while (x > 1 && !isPrime(x)) {
                    x--;
                }
                while (y < n && !isPrime(y)) {
                    y++;
                }
                if (x + y == n) {
                    System.out.println(x);
                    System.out.println(y);
                    break;
                } else if (x + y > n) {
                    x--;
                } else {
                    y++;
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}