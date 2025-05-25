package huawei;

import java.util.Scanner;

public class HJ100_等差数列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取项数n
        int n = in.nextInt();

        // 计算等差数列前n项和
        int sum = calculateArithmeticSequenceSum(n);

        // 输出结果
        System.out.println(sum);
    }

    /**
     * 计算等差数列前n项和
     * 等差数列首项为2，公差为3
     * 
     * @param n 项数
     * @return 前n项和
     */
    private static int calculateArithmeticSequenceSum(int n) {
        // 等差数列首项
        int a1 = 2;
        // 等差数列公差
        int d = 3;

        // 使用等差数列求和公式：Sn = n * a1 + n * (n-1) * d / 2
        return n * a1 + n * (n - 1) * d / 2;
    }
}