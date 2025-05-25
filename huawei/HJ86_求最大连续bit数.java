package huawei;

import java.util.Scanner;

public class HJ86_求最大连续bit数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int max = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int lastone = (number >> i) & 1;
            if (lastone == 1) {
                count++;
                while (i < 32 && ((number >> (i + 1)) & 1) == 1) {
                    count++;
                    i++;
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

}