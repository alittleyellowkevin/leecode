package 链表;

public class 环形链表Ⅱ {
    public static void main(String[] args) {
        // ListNode seventh = new ListNode(5, null);
        // ListNode sixth = new ListNode(4, seventh);
        // ListNode fifth = new ListNode(5, null);
        ListNode forth = new ListNode(4, null);
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);
        forth.next = second;
        detectCycle2(first);
        // reverseBetween(first, 2, 4);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode first = head;
        int number = 1;
        while (first != null) {
            if (first.val <= 50000) {
                first.val = 50000 + number;
                first = first.next;
            } else {
                return first;
            }
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null) {
            return null;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
