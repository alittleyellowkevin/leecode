package huawei;

import java.util.Scanner;

public class HJ107_构造AB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (k < n - 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
