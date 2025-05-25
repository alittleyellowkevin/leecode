package 栈;

import java.util.Stack;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1 ){
            return new int[]{0};
        }
        Stack<Integer> stack =  new Stack<>();
        stack.add(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int k = stack.pop();
                temperatures[k] = i - k;
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            temperatures[stack.pop()] = 0;
        }
        return temperatures;
    }
}
