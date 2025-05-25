package 动态规划;

public class leecode_188_买卖股票的最佳时机Ⅳ {
    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 };
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        // 1. 用一个数组记录第k次交易买入卖出的最大利润
        int[] maxPro = new int[2 * k];

        // 2. 当只有一个数时
        if (prices.length == 1) {
            return 0;
        }

        // 3. 初始化
        for (int i = 0; i < (2 * k); i++) {
            if (i == 0) {
                maxPro[i] = -prices[0];
            } else {
                maxPro[i] = Integer.MIN_VALUE;
            }
        }

        int res = Integer.MIN_VALUE;
        // 4. 递推
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < (2 * k); j++) {
                if (j == 0) {
                    maxPro[j] = Math.max(maxPro[j], -prices[i]);
                } else {
                    if (i >= j) {
                        if (j % 2 == 0) {
                            // 买入
                            maxPro[j] = Math.max(maxPro[j], maxPro[j - 1] - prices[i]);
                        } else {
                            // 卖出
                            maxPro[j] = Math.max(maxPro[j], maxPro[j - 1] + prices[i]);
                        }
                    }
                }
            }

            // 5. 更新最大值
            for (int j = 0; j < 2 * k; j++) {
                res = Math.max(res, maxPro[j]);
            }
        }
        return res;
    }
}
