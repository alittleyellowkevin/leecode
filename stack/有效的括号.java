package stack;

import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        String s = "[](){}[";
        System.out.println(isValid(s));
        
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                if(s.charAt(i) == ')'){
                    if(stack.pop() != '('){
                        return false;
                    }
                }
                if(s.charAt(i) == '}'){
                    if(stack.pop() != '{'){
                        return false;
                    }
                }
                if(s.charAt(i) == ']'){
                    if(stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else {
            return false;
        }
    }
}
