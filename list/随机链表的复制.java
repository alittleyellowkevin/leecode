package list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class 随机链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> res = new HashMap<>();
        Node real = head;
        while (head!=null){
            Node copy = new Node(head.val);
            res.put(head, copy);
            head = head.next;
        }
        for (Node key : res.keySet()) {
            res.get(key).next = res.get(key.next);
            res.get(key).random = res.get(key.random);
        }
        return res.get(real);
    }
}
