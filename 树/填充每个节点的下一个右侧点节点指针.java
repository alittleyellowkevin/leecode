package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 填充每个节点的下一个右侧点节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node now = queue.poll();
                if(i == n-1){
                    now.next = null;
                }else {
                    now.next = queue.peek();
                }
                if(now.left != null) queue.add(now.left);
                if(now.right != null) queue.add(now.right);
            }
        }
        return root;
    }
}
