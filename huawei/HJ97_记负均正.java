package huawei;

import java.util.Scanner;

public class HJ97_记负均正 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取整数个数
        int n = in.nextInt();

        // 初始化变量
        int negativeCount = 0; // 负数个数
        int positiveSum = 0; // 正数之和
        int positiveCount = 0; // 正数个数

        // 读取并处理每个整数
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (num < 0) {
                // 统计负数个数
                negativeCount++;
            } else if (num > 0) {
                // 统计正数之和和个数
                positiveSum += num;
                positiveCount++;
            }
            // 忽略0
        }

        // 计算正数平均值
        double positiveAverage = positiveCount > 0 ? (double) positiveSum / positiveCount : 0.0;

        // 输出结果
        System.out.println(negativeCount + " " + positiveAverage);
    }
}