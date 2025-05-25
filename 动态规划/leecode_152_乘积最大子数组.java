package 动态规划;

import java.util.Arrays;

public class leecode_152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        // 1. dp1表示以当前为终点的最大值 dp2表示以当前节点为终点的最小值
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        // 2. 初始化
        dp1[0] = nums[0];
        dp2[0] = nums[0];

        // 递归
        for (int i = 1; i < nums.length; i++) {
            // 3.最大值可能是由当前点，当前点*最大值，或当前点*最小值
            dp1[i] = Math.max(Math.max((dp1[i - 1] * nums[i]), dp2[i - 1] * nums[i]), nums[i]);
            dp2[i] = Math.min(Math.min((dp1[i - 1] * nums[i]), dp2[i - 1] * nums[i]), nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < dp1[i]) {
                max = dp1[i];
            }
        }
        return max;
    }
}
