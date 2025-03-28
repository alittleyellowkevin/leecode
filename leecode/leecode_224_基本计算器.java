package leecode;

import java.util.Stack;

public class leecode_224_基本计算器 {
    public static void main(String[] args) {
        calculate("(1-(4+5+2)-3)+(6+8)");
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>(); //用于存放括号内是否变号
        int res = 0;
        int sign = 1;
        stack.push(1);

        s = s.replace(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            } else if (c == '+') {
                sign = stack.peek();
            } else if (c == '-') {
                sign = -stack.peek();
            } else {
                int number = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    number = number * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                res += sign * number;
            }
        }
        System.out.println(res);
        return res;
    }
}
