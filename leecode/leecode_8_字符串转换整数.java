package leecode;

public class leecode_8_字符串转换整数 {
    public int myAtoi(String s) {
        //去除空格
        int index = 0;
        long number = 0;
        while (index <= s.length()-1 && s.charAt(index) == ' '){
            index++;
        }
        //判断符号
        boolean negative = false;
        if(index <= s.length()-1 && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            if(s.charAt(index) == '-'){
                negative = true;
            }
            index ++;
        }
        //省略0
        while (index <= s.length()-1 && s.charAt(index) == '0'){
            index++;
        }
        //计算数字
        for (int i = index; i < s.length(); i++) {
            if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                number = number * 10 + (negative ? -1 * (s.charAt(i) - '0') : s.charAt(i) - '0');
                number = negative ? Math.max(number, (long) Integer.MIN_VALUE) : Math.min(number, (long) Integer.MAX_VALUE);
            }else {
                break;
            }
        }
        return (int)number;
    }

}
