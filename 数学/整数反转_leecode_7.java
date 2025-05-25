package 数学;

import java.util.Map;

public class 整数反转_leecode_7 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MAX_VALUE / 10 && res >= Integer.MIN_VALUE / 10) {
                res += res * 10 + x % 10;
                x /= 10;
            } else {
                return 0;
            }
        }
        return res;
    }
}
