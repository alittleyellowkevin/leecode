package 线性表;

import java.util.Arrays;

public class leecode_2962_统计最大元素出现至少K次的子数组 {
    public long countSubarrays(int[] nums, int k) {
        int left = 0; // 左边界
        int right = 0; // 右边界
        int count = 0; // 最大元素出现次数
        long res = 0; // 子数组个数

        int max = Arrays.stream(nums).max().getAsInt();

        for (; left < nums.length; left++) {
            while (right < nums.length && count < k) {
                int number = nums[right];
                if (number == max) {
                    count++;
                }
                right++;
            }
            if (count >= k) {
                res += nums.length - right + 1;
            }
            if (max == nums[left]) {
                count--;
            }
        }

        return res;
    }
}
