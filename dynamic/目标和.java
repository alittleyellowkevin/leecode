package dynamic;

public class 目标和 {
    public static void main(String[] args) {
        int[] nums = {1};
        findTargetSumWays(nums, 1);
    }
    //dp[j] 表示当前值能够有多少种方式获得
    //主要是要明白 sum[p] + sum[n] = target
    //           sum[p] - sum[i] = sum[all]
    //          2sum[p] = target + sum[all]
    //所以只需要求 正数的值 = (target + sum[all])/2 有多少种方式就可以
    //如果target + sum[all] 等于单数或者小于 0 则 两倍正数的值无法等于最后的目标值

    //递推公式 dp[j] += dp[j + num[i]]
    // 也就是当 num[i]取正 取负或者不取的方式加起来

    //初始化 dp[0] = 1, 其余为 0

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

}
