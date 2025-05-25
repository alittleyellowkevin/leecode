package huawei;

import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HJ58_输出最小的k个整数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 整数个数
        int k = in.nextInt(); // 最小的k个数
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        Arrays.sort(numbers);

        for (int i = 0; i < k; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}