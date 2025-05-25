package 线性表;

public class leecode_918_环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        // 数组长度
        int n = nums.length;
        // 数组总和
        int totalSum = 0;
        // 最大子数组和
        int maxSum = nums[0];
        // 最小子数组和
        int minSum = nums[0];
        // 当前最大子数组和
        int currMax = 0;
        // 当前最小子数组和
        int currMin = 0;

        // 遍历数组
        for (int num : nums) {
            // 更新当前最大子数组和
            currMax = Math.max(currMax + num, num);
            // 更新全局最大子数组和
            maxSum = Math.max(maxSum, currMax);
            // 更新当前最小子数组和
            currMin = Math.min(currMin + num, num);
            // 更新全局最小子数组和
            minSum = Math.min(minSum, currMin);
            // 计算数组总和
            totalSum += num;
        }

        // 如果最大子数组和大于0,返回最大子数组和与(总和-最小子数组和)中的较大值
        // 否则返回最大子数组和(处理全为负数的情况)
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}
