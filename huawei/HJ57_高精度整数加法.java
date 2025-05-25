package huawei;

import java.math.BigDecimal;
import java.util.Scanner;

public class HJ57_高精度整数加法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        BigDecimal a = in.nextBigDecimal();
        BigDecimal b = in.nextBigDecimal();

        System.out.println(a.add(b).toString());
        ;
    }
}