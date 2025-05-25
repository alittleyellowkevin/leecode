package 动态规划;

public class leecode_746_使用的最小花费爬楼梯 {
    // i表示到当前台阶所需要花费的最小代价
    public int minCostClimbingStairs(int[] cost) {
        // 首先i表示到达i点所需要的最小代价

        // 递推公式：用i-1点与i-2点中更小的代价来更新第三个点 cost[i] += Math.min(cost[i-1], cost[i-2]);

        // 初始化前两个台阶就行

        for (int i = 2; i < cost.length + 1; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
