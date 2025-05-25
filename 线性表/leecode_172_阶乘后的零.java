package 线性表;

public class leecode_172_阶乘后的零 {
    public static void main(String[] args) {
        trailingZeroes(15);
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            while (number % 5 == 0) {
                count++;
                number /= 5;
            }
        }
        return count;
    }
}
