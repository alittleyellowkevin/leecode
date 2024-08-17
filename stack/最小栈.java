package stack;

import java.util.Stack;

public class 最小栈 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public 最小栈() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty()){
            stack2.push(val);
        }else {
            if(val<stack2.peek()){
                stack2.push(val);
            }else {
                stack2.push(stack2.peek());
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
