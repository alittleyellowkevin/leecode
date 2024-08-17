package stack;

import java.util.Stack;

public class 删除字符串中所有相邻重复项 {
    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty()){
                if(stack.peek() == s.charAt(i)){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
