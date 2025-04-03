package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HJ16_购物单 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPrice = scanner.nextInt() / 10;
        int n = scanner.nextInt();

        HashMap<Integer, List<int[]>> fmap = new HashMap<>(); // key: 主件 id， value: 主件的附件列表
        HashMap<Integer, int[]> pmap = new HashMap<>(); // key: 主件 id， value: 主件的价格,价值
        int[] dp = new int[totalPrice + 1];
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt() / 10;
            int value = scanner.nextInt();
            int keyid = scanner.nextInt();

            if (keyid == 0) {
                // 主件
                int[] p = { price, value };
                pmap.put(i + 1, p);
            } else {
                // 附件
                int[] p = { price, value };
                List<int[]> list = fmap.get(keyid);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(p);
                    fmap.put(keyid, list);
                } else {
                    list.add(p);
                }
            }
        }

        // 1.确认dp[i]的含义：dp[i]表示在总价为i的情况下，所能获得的最大价值
        // 2.确认状态转移方程：dp[i] = Math.max(dp[i], dp[i - p[0]] + p[1]); 同时要考虑附件情况
        // 3.确认初始化：dp[0] = 0;
        // 4.确认遍历顺序：从前往后遍历
        for (Integer key : pmap.keySet()) {
            for (int i = totalPrice; i > 0; i--) {
                {
                    int[] p = pmap.get(key);
                    List<int[]> list = fmap.get(key);

                    // 首先处理主键, 当前价格可以购买时，则dp[i] = dp[i-1] 或者 dp[i - p[0]] + p[0] * p[1]
                    if (i >= p[0]) {
                        dp[i] = Math.max(dp[i], dp[i - p[0]] + p[0] * p[1]);
                        if (list != null) {
                            int sumPrice = 0; // 附件总价格
                            int sumValue = 0; // 附件总价值

                            // 一个附件 + 一个主件的情况
                            for (int[] priceValue : list) {
                                if (i >= p[0] + priceValue[0]) {
                                    dp[i] = Math.max(dp[i], (dp[i - p[0] - priceValue[0]] + p[0] * p[1]
                                            + priceValue[0] * priceValue[1]));
                                    sumPrice += priceValue[0];
                                    sumValue += priceValue[0] * priceValue[1];
                                }
                            }

                            // 两个附件 + 一个主件的情况
                            if (i >= sumPrice + p[0]) {
                                dp[i] = Math.max(dp[i], dp[i - p[0] - sumPrice] + p[0] * p[1] + sumValue);
                            }
                        }
                    }

                }
            }
        }
    }
}
