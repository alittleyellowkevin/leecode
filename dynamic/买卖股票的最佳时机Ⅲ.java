package dynamic;

public class 买卖股票的最佳时机Ⅲ {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4, 5};
        maxProfit(prices);
    }
    public static int maxProfit(int[] prices) {
        //1，dp[i][0] 表示持有一次最大的价值
        //2. dp[i][1] 表示持有两次的最大值
        //3. dp[i][2] 表示不持有第一次的最大值
        //4. dp[i][3] 表示不持有第二次的最大值

        //递推方程


        //初始化

        //循环

        if(prices.length == 1){
            return 0;
        }
        if(prices.length == 2){
            if(prices[1] > prices[0]){
                return prices[1] - prices[0];
            }
            return 0;
        }

        int[][] dp = new int[prices.length][4];

        //初始化
        dp[0][0] = -prices[0];
        dp[1][1] = Integer.MIN_VALUE;
        dp[2][3] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            //第一次买入时的最大价值 = Max(上次买入的最大价值，现在重新买入）

            dp[i][2] = Math.max(dp[i-1][0]+prices[i], dp[i-1][2]);
            //第一次卖出的最大价值 = Max（现在卖出的价值，上次第一次卖出卖出的最大价值）

            if(i>=2){
                dp[i][1] = Math.max(dp[i-1][2]-prices[i], dp[i-1][1]);
                // 第二次买入的最大价值 = max（第一次卖出-price， 上次第二次买入的最大价值）
            }
            if(i>=3){
                dp[i][3] = Math.max(dp[i-1][1]+prices[i], dp[i-1][3]);
                //第二次卖出的最大价值 = max（第二次持有的最大价值+现在卖出的价值， 上次第二次卖出的价值）
            }
        }
        return Math.max(dp[prices.length-1][2], dp[prices.length-1][3]);

    }
}
