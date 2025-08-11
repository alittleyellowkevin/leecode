package 线性表;

import java.util.Arrays;

public class leecode_1498_满足条件的子序列数目 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = 1_000_000_007;
        int left = 0, right = n - 1;
        int result = 0;

        // 预计算 2^i % mod
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
