package dynamic;

public class 买卖股票的最佳时机 {
    //用一个数记录当前经过的最小value，利用之后
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public int maxProfiDynamic(int[] prices) {
        // dp[i][0] 表示持有价值的最大值
        // dp[i][0] 不持有的价值的最大值

        //递推公式
        //dp[i][0] = max(-price[i],dp[i-1][0]  也就是求持有的最大值
        //dp[i][1] = max(dp[i-1][1], dp[i-1][0] + price[i])
        // 不持有分两种情况，1之前持有现在不持有，2之前也不持有

        //初始化dp[0][0] = -price[0]
        //dp[0][1] = 0



        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[length][2];
        int result = 0;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][1];
    }
}
