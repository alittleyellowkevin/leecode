package huawei;

import java.util.Scanner;

public class HJ24_合唱队 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] heights = new int[n][3]; // heigt[0][1] 从左到右最大子序列长度，height[0][2]//从右到左的最大子序列长度
            for (int i = 0; i < n; i++) {
                heights[i][0] = in.nextInt();
                heights[i][1] = 1;
                heights[i][2] = 1;
            }

            // 最大左连续序列
            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (heights[i][0] > heights[j][0]) {
                        heights[i][1] = Math.max(heights[i][1], heights[j][1] + 1);
                    }
                }
            }

            // 最大右连续序列
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (heights[i][0] > heights[j][0]) {
                        heights[i][2] = Math.max(heights[i][2], heights[j][2] + 1);
                    }
                }
            }

            int count = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                count = Math.max(count, heights[i][1] + heights[i][2] - 1);
            }

            System.out.println(n - count);

        }
    }

}
