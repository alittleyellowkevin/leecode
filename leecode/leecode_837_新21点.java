package leecode;

public class leecode_837_新21点 {
    public double new21Game(int n, int k, int maxPts) {
        // 特殊情况：k=0时，无法抽卡，分数为0
        if (k == 0) {
            return n >= 0 ? 1.0 : 0.0;
        }

        // dp[i] 表示从分数i开始的获胜概率
        double[] dp = new double[k];

        // 计算每个状态的概率
        for (int i = k - 1; i >= 0; i--) {
            // 抽卡后可能的总分范围：i+1 ~ i+maxPts
            int minTotal = i + 1;
            int maxTotal = i + maxPts;

            // 情况1：所有可能的抽卡结果都 >=k（即停止游戏）
            if (minTotal >= k) {
                // 统计其中 <=n 的数量
                int validCount = Math.min(maxTotal, n) - minTotal + 1;
                validCount = Math.max(validCount, 0); // 避免负数
                dp[i] = (double) validCount / maxPts;
            }
            // 情况2：部分结果 <k（可继续抽卡），部分 >=k（停止）
            else {
                // 先计算 <k 的部分（i+1 ~ k-1）的概率和
                double sum = 0;
                int end = Math.min(k - 1, maxTotal);
                for (int j = minTotal; j <= end; j++) {
                    sum += dp[j];
                }
                // 再计算 >=k 的部分（k ~ maxTotal）中 <=n 的概率
                int validCount = Math.min(maxTotal, n) - k + 1;
                validCount = Math.max(validCount, 0);
                sum += validCount; // 这部分每一种的概率是1/maxPts，总和是 validCount/maxPts

                dp[i] = sum / maxPts;
            }
        }

        return dp[0];
    }
}
