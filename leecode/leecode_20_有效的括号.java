package leecode;

import java.util.Stack;

public class leecode_20_有效的括号 {
    public static void main(String[] args) {
        isValid("]");
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if(!stack.isEmpty() &&( (stack.peek()=='(' && s.charAt(i)==')') || (stack.peek()=='[' && s.charAt(i)==']')||(stack.peek()=='{' && s.charAt(i)=='}'))){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}
