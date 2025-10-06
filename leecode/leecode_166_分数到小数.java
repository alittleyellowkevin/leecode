package leecode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leecode_166_分数到小数 {
    public String fractionToDecimal(int numerator, int denominator) {
        // 特殊情况：分子为 0，直接返回 "0"
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // 处理正负号：异或 (^) 表示一正一负
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");

        // 转 long，避免 int 范围溢出（-2^31 取绝对值会越界）
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 整数部分：直接整除
        sb.append(num / den);

        // 余数
        long rem = num % den;

        // 如果整除，没有小数部分，直接返回
        if (rem == 0) return sb.toString();

        // 否则有小数部分，加上小数点
        sb.append(".");

        // map 存放：余数 → 对应结果字符串中的位置
        // 用来检测循环小数出现的位置
        Map<Long, Integer> map = new HashMap<>();

        // 模拟长除法
        while (rem != 0) {
            // 如果当前余数已经出现过，说明开始循环
            if (map.containsKey(rem)) {
                // 在余数第一次出现的位置插入 "("
                sb.insert(map.get(rem), "(");
                // 在末尾补上 ")"
                sb.append(")");
                break;
            }

            // 记录当前余数对应的结果位置（sb 当前长度）
            map.put(rem, sb.length());

            // 余数扩大 10 倍，进行下一位除法
            rem *= 10;
            sb.append(rem / den);  // 商
            rem %= den;            // 更新余数
        }

        // 返回最终结果
        return sb.toString();
    }
}
