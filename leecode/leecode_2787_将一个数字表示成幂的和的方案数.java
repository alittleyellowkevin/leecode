package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_2787_将一个数字表示成幂的和的方案数 {
    public static int mod = 1000000007;
    public int numberOfWays(int n, int x) {
        // 首先要将所有 数的 x 次方 小于 n 的存储
        int i = 1;
        List<Integer> list = new ArrayList<>();
        while(Math.pow(i, x) <= (double)n){
            list.add((int)Math.pow(i, x));
            i++;
        }

        //dp[i] 表示 值为 i 时最大方案数
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int number:list){
            for(i=n; i>=0; i--){
                if( i - number >= 0){
                    dp[i] = (dp[i] + dp[i - number]) % mod;
                }
            }
        }
        return dp[n];
    }
}
