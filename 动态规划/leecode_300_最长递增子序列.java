package 动态规划;

import java.util.HashMap;

public class leecode_300_最长递增子序列 {
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        int maxLength = 1; // 最大子序列长度

        // maxLengthArray[i] 表示以 nums[i]结尾最长的子序列长度
        int[] maxLengthArray = new int[nums.length];

        // 初始化
        maxLengthArray[0] = 1;

        // 循环
        for (int i = 1; i < maxLengthArray.length; i++) {
            int currentMaxLength = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    currentMaxLength = Math.max(maxLengthArray[j], currentMaxLength);
                }
            }
            maxLengthArray[i] = currentMaxLength + 1;
            maxLength = Math.max(maxLengthArray[i], maxLength);
        }

        return maxLength;
    }

    // 贪心 + 二分
    public int lengthOfLIS2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.getOrDefault(map, null);
        // tails[i]表示长度为i+1的递增子序列的最小尾部元素
        int[] tails = new int[nums.length];
        int maxLen = 0; // 当前最长递增子序列长度

        for (int num : nums) {
            // 二分查找,找到第一个大于num的位置
            int left = 0, right = maxLen;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            // 如果是插入到最后,则更新长度
            if (left == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }
}
