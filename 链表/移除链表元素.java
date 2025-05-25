package 链表;

public class 移除链表元素 {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;
        ListNode pre = dummy_head;
        ListNode now = head;
        while (now != null) {
            if (now.val == val) {
                pre.next = now.next;
                now = pre.next;
            } else {
                pre = pre.next;
                now = now.next;
            }
        }
        return dummy_head.next;
    }
}
