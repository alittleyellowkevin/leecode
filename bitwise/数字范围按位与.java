package bitwise;

public class 数字范围按位与 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        rangeBitwiseAnd(0, 0);
    }
    public static int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for (int i = 0; i <32 ; i++) {
            int number = 1;
            for (int j = left; j <= right; j++) {
                number &= j>>>i;
            }
            res |= number<<i;
        }
        return res;
    }
}
