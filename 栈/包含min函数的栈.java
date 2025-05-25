package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 包含min函数的栈 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else {
            if(node > stack2.peek()){
                stack2.push(stack2.peek());
            }else {
                stack2.push(node);
            }
        }
    }

    public void pop() {
        stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
