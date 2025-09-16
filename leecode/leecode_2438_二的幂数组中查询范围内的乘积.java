package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_2438_二的幂数组中查询范围内的乘积 {
    public static int mod = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[queries.length];
        for(int i=0; i<30; i++){
            int oneOrZero = (n >> i) & 1;
            if(oneOrZero == 1){
                int pre = list.size()==0 ? 0:list.get(list.size()-1);
                list.add(i + pre);
            }
        }
        for(int i=0; i<queries.length; i++){
            int left = queries[i][0]-1;
            int right = queries[i][1];

            if(left<0){
                result[i] = pow2(list.get(right)) % mod;
            }else{
                result[i] = pow2(list.get(right) - list.get(left)) % mod;
            }
        }
        return result;
    }
    // 快速幂计算：2^exponent mod MOD
    private int pow2(int exponent) {
        long result = 1;
        long base = 2;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return (int) result;
    }
}
