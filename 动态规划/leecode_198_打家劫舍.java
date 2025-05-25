package 动态规划;

public class leecode_198_打家劫舍 {
    public static void main(String[] args) {
        int[] nums = { 100, 1, 2, 100, 1, 2, 100 };
        rob(nums);
    }

    public static int rob(int[] nums) {
        // 1. dp[i]表示当前点偷取最大钱数
        int[] res = new int[nums.length];
        if (nums.length == 1)
            return nums[0];

        // 2. 初始化数组
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // 3. 递推公式：dp[j] = Math.max(dp[j-2] + nums[i], dp[j-1])
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
        }
        return res[nums.length - 1];
    }

}
