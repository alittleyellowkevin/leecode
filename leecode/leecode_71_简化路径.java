package leecode;

import java.util.Stack;

public class leecode_71_简化路径 {
    public static String simplifyPath(String path) {
        String[] split =  path.split("/");
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();
        for (int i = 0; i <split.length; i++) {
            if(split[i].equals("")){
                continue;
            }
            if(split[i].equals(".")){
                continue;
            }
            if(split[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            stack.push(split[i]);
        }

        StringBuffer sb = new StringBuffer();
        if(stack.isEmpty()){
            return new String("/");
        }
        sb.append('/');

        while (!stack.isEmpty())
        {
            stack1.push(stack.pop());
        }
        while (!stack1.isEmpty()){
            sb.append(stack1.pop());
            sb.append('/');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
