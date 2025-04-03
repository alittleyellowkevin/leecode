package huawei;

import java.util.Scanner;

public class HJ22_汽水瓶 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n == 0)
                break;
            System.out.println(n / 2);
        }
    }
}