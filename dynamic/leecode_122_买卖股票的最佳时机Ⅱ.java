package dynamic;

public class leecode_122_买卖股票的最佳时机Ⅱ {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res = res + prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
