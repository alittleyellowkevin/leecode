package huawei;

import java.util.Scanner;

public class HJ103_Redraiment的走法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        int[] res = new int[n];
        res[0] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            int height = numbers[i];
            res[i] = 1;
            for (int j = i - 1; j >= 0; j++) {
                if (height > numbers[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
            max = Math.max(max, res[i]);
        }
        System.out.println(max);
    }
}
