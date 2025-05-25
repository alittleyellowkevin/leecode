package 动态规划;

public class leecode_322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        // 1. dp[i]表示 -1表示当前节点不可达，否则表示当前节点所需的最少硬币数量
        int[] res = new int[amount + 1];

        // 2. 初始化 dp[0]设置为0 其他的设置为-1
        for (int i = 0; i <= amount; i++) {
            if (i == 0) {
                res[i] = 0;
            } else {
                res[i] = -1;
            }
        }

        // 3. 递推公式 当节点可达时 与 节点不可达时分类
        for (int i = 1; i < amount + 1; i++) {
            int minLen = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && res[i - coins[j]] != -1) {
                    minLen = Math.min(minLen, res[i - coins[j]] + 1);
                }
            }
            if (minLen != Integer.MAX_VALUE) {
                res[i] = minLen;
            }
        }
        return res[amount];
    }
}
