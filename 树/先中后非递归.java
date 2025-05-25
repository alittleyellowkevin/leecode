package 树;

import java.util.Stack;

public class 先中后非递归 {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left !=null){
                    stack.push(head.left);
                }
            }
        }
    }
    public static void inOrderUnRecur(Node head){
        System.out.println("in-order:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    head = head.right;
                }
            }
        }
    }
    public static void posOrderUnRecur(Node head){
        System.out.println("pos-order");
        if(head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                System.out.println(head.value);
                if(head.right != null){
                    s1.push(head.right);
                }
                if(head.left != null){
                    s1.push(head.left);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }

}
