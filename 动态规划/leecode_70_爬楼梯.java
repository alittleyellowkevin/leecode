package 动态规划;

import java.util.ArrayList;

public class leecode_70_爬楼梯 {
    public static void main(String[] args) {
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int number1 = 1;
        int number2 = 2;
        int number3 = 0;
        for (int i = 3; i <= n; i++) {
            number3 = number1 + number2;
            number1 = number2;
            number2 = number3;
        }
        return number3;
    }
}
