package leecode;

import java.util.Map;
import java.util.Stack;

public class leecode_32_最长有效括号 {
    public static void main(String[] args) {
        longestValidParentheses("()");
    }
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i+1);
            }else {
                if(!stack.isEmpty() && stack.peek() > 0){
                    stack.pop();
                }else {
                    stack.push(-1*(i+1));
                }
            }
        }
        if(stack.isEmpty()){
            return s.length();
        }
        int result = 0;
        int pre = s.length();
        while (!stack.isEmpty()) {
            int now = stack.peek()>0? stack.peek()-1:-1*stack.peek()-1;
            result = Math.max(pre-now-1, result);
            pre = now;
            if(stack.size() == 1){
                result = Math.max(result, now);
            }
            stack.pop();
        }
        return result;
    }
}
