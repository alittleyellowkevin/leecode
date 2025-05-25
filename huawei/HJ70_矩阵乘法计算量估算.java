package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HJ70_矩阵乘法计算量估算 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(in.nextInt(), in.nextInt()));
        }
        String line = in.next();
        int res = 0;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ')') {
                Node node1 = stack.pop();
                Node node2 = stack.pop();
                res += node2.left * node2.right * node1.right;
                stack.push(new Node(node2.left, node1.right));
            } else if (line.charAt(i) == '(') {

            } else {
                stack.add(list.get((line.charAt(i) - 'A')));
            }
        }
        System.out.println(res);
    }

    static class Node {
        int left;
        int right;

        public Node(int a, int b) {
            left = a;
            right = b;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
}
