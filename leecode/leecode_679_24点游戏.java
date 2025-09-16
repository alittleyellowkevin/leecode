package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_679_24点游戏 {
    // 用于处理浮点数精度问题的小数值
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        // 将整数转换为double，方便处理除法
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }

        return backtrack(nums);
    }

    private boolean backtrack(List<Double> nums) {
        // 当只剩下一个数字时，检查是否接近24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < EPSILON;
        }

        // 尝试所有可能的两个数字组合
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 不能选择同一个数字
                if (i != j) {
                    double a = nums.get(i);
                    double b = nums.get(j);

                    // 创建剩余数字的列表
                    List<Double> remaining = new ArrayList<>();
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            remaining.add(nums.get(k));
                        }
                    }

                    // 尝试加法
                    remaining.add(a + b);
                    if (backtrack(remaining)) return true;
                    remaining.remove(remaining.size() - 1);

                    // 尝试减法
                    remaining.add(a - b);
                    if (backtrack(remaining)) return true;
                    remaining.remove(remaining.size() - 1);

                    // 尝试乘法
                    remaining.add(a * b);
                    if (backtrack(remaining)) return true;
                    remaining.remove(remaining.size() - 1);

                    // 尝试除法（避免除以0）
                    if (Math.abs(b) > EPSILON) {
                        remaining.add(a / b);
                        if (backtrack(remaining)) return true;
                        remaining.remove(remaining.size() - 1);
                    }
                }
            }
        }

        // 所有组合都尝试过，无法得到24
        return false;
    }
}
