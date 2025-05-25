package huawei;

import java.util.Scanner;

public class HJ72_百钱买百鸡 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j < 40; j++) {
                for (int k = 0; k <= 100; k++) {
                    if (i + j + k == 100 && k % 3 == 0 && (5 * i + 3 * j + k / 3) == 100) {
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
}
