package 位运算;

public class leecode_190_颠倒二进制位 {
    public static void main(String[] args) {
        int i = -1;
        System.out.println(i>>>1);
    }
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;

    }
}
