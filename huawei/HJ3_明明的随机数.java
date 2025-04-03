package huawei;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ3_明明的随机数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (array[j] > array[j - 1]) {
                        int mid = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = mid;
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (i != n - 1 && array[i] == array[i + 1]) {
                    continue;
                }
                System.out.println(array[i]);
            }

        }
    }
}