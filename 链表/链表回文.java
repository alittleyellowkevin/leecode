package 链表;

public class 链表回文 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // need O(1) extra space
    public static boolean isHuiWen(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = p1.next;
        p1.next = null;
        Node p3 = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        p3 = p1;
        p2 = head;
        boolean res = true;
        while (p1 != null && p2 != null) {
            if (p1.value != p2.value) {
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        p1 = p3.next;
        p3.next = null;
        while (p1 != null) {
            p2 = p1.next;
            p1.next = p3;
            p3 = p1;
            p1 = p2;
        }
        return res;

    }
}
