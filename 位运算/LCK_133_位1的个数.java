package 位运算;

public class LCK_133_位1的个数 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if((n&1)==1){
                res++;
            }
            n >>>=1;
        }
        return res;
    }
}
