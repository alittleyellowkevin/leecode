package dynamic;

public class leecode_518_零钱兑换Ⅱ {
    public int change(int amount, int[] coins) {
        // dp[i] 表示零钱组成i的种类数

        // 递推公式：dp[i] += dp[j-coins[i]] 也就是如果当前j可以由j-coins[i]得到

        // 初始化将dp[0]设置为1 即当背包为0时只有一种方式

        // 先递推物品再递推背包

        int[] dp = new int[amount + 1];
        // 初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
