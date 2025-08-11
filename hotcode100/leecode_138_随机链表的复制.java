package hotcode100;

import java.util.HashMap;

public class leecode_138_随机链表的复制 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node node = head;
        Node dummyHead = new Node(0);
        Node tail = dummyHead;
        while (node != null){
            Node newNode = new Node(node.val);
            tail.next = newNode;
            tail = newNode;
            hashMap.put(node, newNode);
            node = node.next;
        }
        node = dummyHead.next;
        while (node != null && head != null){
            node.random = hashMap.get(head.random);
            node = node.next;
            head = head.next;
        }
        return dummyHead.next;
    }
}
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
