package dynamic;

public class 组合总和Ⅳ {
    public static void main(String[] args) {

    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        //dp[i]表示当前背包的最大种类数

        //递推公式 dp[j] += dp[j-num[i]]

        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装

        //要先遍历背包，遍历物品
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if(j-nums[i]>=0)
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
