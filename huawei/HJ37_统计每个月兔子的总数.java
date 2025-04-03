package huawei;

import java.util.Scanner;

public class HJ37_统计每个月兔子的总数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] result = new int[n];

            result[0] = 1;
            for (int i = 1; i < n; i++) {
                if (i >= 2) {
                    result[i] = result[i - 1] + result[i - 2];
                } else {
                    result[i] = result[i - 1];
                }
            }
            System.out.println(result[n - 1]);
        }
    }

}
