package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hard_HJ82_将真分数分解为埃及数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] fraction = scanner.next().split("/");
            int a = Integer.parseInt(fraction[0]);
            int b = Integer.parseInt(fraction[1]);
            List<Integer> denominators = egyptianFraction(a, b);
            for (int denominator : denominators) {
                System.out.print(denominator + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    // 计算最大公约数
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static List<Integer> egyptianFraction(int a, int b) {
        // 约分分数
        int gcdVal = gcd(a, b);
        a /= gcdVal;
        b /= gcdVal;

        List<Integer> denominators = new ArrayList<>();

        while (a != 0) {
            if (a == 1) {
                denominators.add(b);
                break;
            }
            // 计算最大的埃及分数的分母x
            int x = (b + a - 1) / a; // 等价于ceil(b/a)
            denominators.add(x);
            // 更新分子和分母
            int aNew = a * x - b;
            int bNew = b * x;
            // 约分新的分数
            int gcdNew = gcd(aNew, bNew);
            a = aNew / gcdNew;
            b = bNew / gcdNew;
        }

        return denominators;
    }
}
