package huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ41_称砝码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(); // 砝码的种数
            int[] weights = new int[n]; // 每个砝码的重量
            int[] counts = new int[n]; // 每个砝码的数量

            // 读取每个砝码的重量
            for (int i = 0; i < n; i++) {
                weights[i] = in.nextInt();
            }

            // 读取每个砝码的数量
            for (int i = 0; i < n; i++) {
                counts[i] = in.nextInt();
            }

            int result = calculatePossibleWeights(weights, counts);
            System.out.println(result);
        }
    }

    private static int calculatePossibleWeights(int[] weights, int[] counts) {
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * counts[i];
            for (int j = 0; j < counts[i]; j++) {
                list.add(weights[i]);
            }
        }
        boolean[] res = new boolean[sum + 1];
        res[0] = true;
        for (int i = 0; i < list.size(); i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - list.get(i) >= 0) {
                    res[j] = res[j] || res[j - list.get(i)];
                }
            }
        }
        int resCount = 0;
        for (int i = 0; i < sum + 1; i++) {
            if (res[i])
                resCount++;
        }
        return resCount;
    }
}