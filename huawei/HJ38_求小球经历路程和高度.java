package huawei;

import java.math.BigDecimal;
import java.util.*;

public class HJ38_求小球经历路程和高度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            BigDecimal n = in.nextBigDecimal();

            BigDecimal resPath = BigDecimal.ZERO;

            resPath = resPath.add(n);
            for (int i = 0; i < 4; i++) {
                n = n.divide(BigDecimal.valueOf(2));
                resPath = resPath.add(n.multiply(BigDecimal.valueOf(2)));
            }
            System.out.println(resPath);
            System.out.println(n.divide(BigDecimal.valueOf(2))); // 输出结果
        }
    }
}