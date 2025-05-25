package huawei;

import java.util.*;

public class Hard_HJ50_四则运算 {
    public static void main(String[] args) {
        List<String> postList = new ArrayList<>(); // 用于存储列表的后缀表达式
        Deque<Character> deque = new LinkedList<>(); // 用于存储符号栈

        Scanner in = new Scanner(System.in);
        String midString = in.nextLine().trim();
        midString = midString.replace("{", "(");
        midString = midString.replace("}", ")");
        midString = midString.replace("[", "(");
        midString = midString.replace("]", ")");

        // 遍历中序表达式
        for (int i = 0; i < midString.length(); i++) {
            char currentChar = midString.charAt(i);
            // 当为数字时，查看是否为多位数
            if (Character.isDigit(currentChar)) {
                int j = i;
                while (j < midString.length() && Character.isDigit(midString.charAt(j))) {
                    j++;
                }
                postList.add(midString.substring(i, j));
                i = j - 1;
            }
            // 当为乘除直接加入栈中
            else if (currentChar == '*' || currentChar == '/') {
                while (!deque.isEmpty() && (deque.peek() == '*' || deque.peek() == '/')) {
                    postList.add(deque.pop().toString());
                }
                deque.push(currentChar);
            }
            // 当为加减时
            else if (currentChar == '+' || currentChar == '-') {
                while (!deque.isEmpty()
                        && (deque.peek() == '*' || deque.peek() == '/' || deque.peek() == '+' || deque.peek() == '-')) {
                    postList.add(deque.pop().toString());
                }
                deque.push(currentChar);
            }
            // 当为左括号时，直接入栈
            else if (currentChar == '(') {
                deque.push(currentChar);
            }
            // 当为右括号时，弹出栈内元素直到遇到左括号
            else if (currentChar == ')') {
                while (!deque.isEmpty() && deque.peek() != '(') {
                    postList.add(deque.pop().toString());
                }
                if (!deque.isEmpty() && deque.peek() == '(') {
                    deque.pop(); // 弹出左括号
                }
            }
        }

        // 将栈中剩余的运算符添加到后缀表达式中
        while (!deque.isEmpty()) {
            postList.add(deque.pop().toString());
        }

        // 计算后缀表达式的结果
        int result = calculatePostfix(postList);
        System.out.println(result);
    }

    private static int calculatePostfix(List<String> postList) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : postList) {
            char c = s.charAt(0);
            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
