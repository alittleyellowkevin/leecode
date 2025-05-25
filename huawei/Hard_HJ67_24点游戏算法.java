package huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Hard_HJ67_24点游戏算法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[4];

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        List<Double> nums = new ArrayList<>();
        for (int num : array) {
            nums.add((double) num);
        }

        System.out.println(canMake24(nums) ? "true" : "false");
    }

    private static boolean canMake24(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 0.0001;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                double num1 = nums.get(i);
                double num2 = nums.get(j);

                List<Double> remainingNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        remainingNums.add(nums.get(k));
                    }
                }

                // 尝试所有可能的运算
                // 加法
                remainingNums.add(num1 + num2);
                if (canMake24(remainingNums)) {
                    return true;
                }
                remainingNums.remove(remainingNums.size() - 1);

                // 减法 (num1 - num2)
                remainingNums.add(num1 - num2);
                if (canMake24(remainingNums)) {
                    return true;
                }
                remainingNums.remove(remainingNums.size() - 1);

                // 减法 (num2 - num1)
                remainingNums.add(num2 - num1);
                if (canMake24(remainingNums)) {
                    return true;
                }
                remainingNums.remove(remainingNums.size() - 1);

                // 乘法
                remainingNums.add(num1 * num2);
                if (canMake24(remainingNums)) {
                    return true;
                }
                remainingNums.remove(remainingNums.size() - 1);

                // 除法 (num1 / num2)
                if (Math.abs(num2) > 0.0001) {
                    remainingNums.add(num1 / num2);
                    if (canMake24(remainingNums)) {
                        return true;
                    }
                    remainingNums.remove(remainingNums.size() - 1);
                }

                // 除法 (num2 / num1)
                if (Math.abs(num1) > 0.0001) {
                    remainingNums.add(num2 / num1);
                    if (canMake24(remainingNums)) {
                        return true;
                    }
                    remainingNums.remove(remainingNums.size() - 1);
                }
            }
        }
        return false;
    }
}