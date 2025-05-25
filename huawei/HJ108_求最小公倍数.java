package huawei;

import java.util.Scanner;

public class HJ108_求最小公倍数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int gys = fingGYS(a, b);
        System.out.println(a * b / gys);
    }

    public static int fingGYS(int a, int b) {
        while (a != 0) {
            int tem = a;
            a = b % a;
            b = tem;
        }
        return b;
    }
}
