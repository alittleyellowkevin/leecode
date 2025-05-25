package 数学;

public class 数值的整数次方_leecode_50 {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double res = base;
        for (int i = 1; i < exponent; i++) {
            res *= base;
        }
        return res;
    }
}
