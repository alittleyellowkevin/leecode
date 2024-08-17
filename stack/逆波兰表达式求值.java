package stack;

import java.util.Stack;

public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        String[] tokens = {"3", "-4", "+"};
        System.out.println(evalRPN(tokens));

    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(isNumber(tokens[i])){
                if(tokens[i].charAt(0) == '-'){
                    stack.push(-stringToNumber(tokens[i].substring(1)));
                }else {
                    stack.push(stringToNumber(tokens[i]));
                }
            }else {
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(cul(number1, number2, tokens[i]));
            }
        }
        return stack.peek();
    }

    private static Integer cul(int number1, int number2, String token) {
        if(token.equals("+")){
            return number2 + number1;
        } else if (token.equals("-")) {
            return number2 - number1;
        } else if (token.equals("*")) {
            return number2 * number1;
        } else {
            return number2 / number1;
        }
    }

    public static boolean isNumber(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }else {
            return true;
        }
    }
    public static int stringToNumber(String s){
        int number = 0;
        for (int i = s.length()-1; i >=0; i--) {
            number = number + (s.charAt(i) - '0') * (int)(Math.pow(10, s.length()-1 - i));
        }
        return number;
    }
}
