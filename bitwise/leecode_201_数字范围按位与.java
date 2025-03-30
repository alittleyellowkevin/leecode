package bitwise;

public class leecode_201_数字范围按位与 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        rangeBitwiseAnd(0, 0);
    }
    public static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}
