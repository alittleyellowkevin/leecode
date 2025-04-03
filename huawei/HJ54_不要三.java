package huawei;

import java.util.Scanner;

public class HJ54_不要三 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int result = calculateValidNumbers(n);
            System.out.println(result);
        }
    }

    private static int calculateValidNumbers(int n) {
        // TODO: 实现计算不包含3的数字的个数
        // 1. 数字不能是3的倍数
        // 2. 数字中不能包含数字3
        return 0;
    }

    private static boolean isValid(int num) {
        // TODO: 判断一个数字是否满足条件
        // 1. 不是3的倍数
        // 2. 不包含数字3
        return false;
    }
}