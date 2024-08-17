package number;

public class 字符串相乘 {
    public static void main(String[] args) {
        System.out.println(toString(toNumber("123")));
    }
    public String multiply(String num1, String num2) {
        long number1 = toNumber(num1);
        long number2 = toNumber(num2);
        long number3 = number1 * number2;
        String res = toString(number3);
        return res;
    }
    public static long toNumber(String str){
        long res=0;
        for (int i = str.length()-1; i >=0; i--) {
            res += (str.charAt(i) - '0') * Math.pow(10, str.length()-1-i);
        }
        return res;
    }
    public static String toString(long number){
        StringBuffer sb = new StringBuffer();
        while(number != 0){
            sb.append(number%10);
            number = number /10;
        }
        sb.reverse();
        return sb.toString();
    }
}
