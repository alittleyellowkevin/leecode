package dynamic;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        //dp[i]表示 -1表示当前节点不可达，否则表示当前节点所需的最少硬币数量

        //递推公式 当节点可达时 与 节点不可达时分类

        //初始化 dp[0]设置为0 其他的设置为-1

        //循环顺序无所谓

        int[] res = new int[amount+1];
        for (int i = 0; i <= amount; i++) {
            if(i == 0){
                res[i] = 0;
            }else {
                res[i] = -1;
            }
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //当前值是否可达
                if(res[j] == -1){
                    //当前值不可达
                    if(res[j-coins[i]] != -1){
                        //若取该硬币则可达直接加一
                        res[j] = res[j-coins[i]]+1;
                    }
                    //否则不变
                }else {
                    //当前值可达时
                    if(res[j-coins[i]] != -1){
                        //取该硬币也可达时
                        res[j] = Math.min(res[j-coins[i]] + 1, res[j]);
                    }
                }
            }
        }
        return res[amount];
    }
}
