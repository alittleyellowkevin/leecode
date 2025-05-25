package 链表;

public class 两两交换链表中的节点 {
    public static void main(String[] args) {

        ListNode forth = new ListNode(4, null);
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);
        swapPairs(first);
    }

    // public static class ListNode {
    // int val;
    // ListNode next;
    // ListNode() {}
    // ListNode(int val) { this.val = val; }
    // ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }
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

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;
        ListNode pre = dummy_head;
        ListNode mid = head;
        ListNode nex = head.next;
        while (nex.next != null && nex.next.next != null) {
            mid.next = nex.next;
            pre.next = nex;
            nex.next = mid;
            pre = mid;
            mid = mid.next;
            nex = mid.next;
        }
        mid.next = nex.next;
        pre.next = nex;
        nex.next = mid;
        return dummy_head.next;
    }
}
