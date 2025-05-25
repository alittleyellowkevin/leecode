package huawei;

import java.util.Scanner;

public class HJ114_小红的正整数构造 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int target = in.nextInt();
        for (int i = l; i <= r; i++) {
            if (i % target == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}