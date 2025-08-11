package hotcode100;

import model.ListNode;

public class leecode_142_环形链表Ⅱ {
    public static void main(String[] args) {
        ListNode one = new ListNode<>(1);
        ListNode two = new ListNode<>(2);
        one.next = two;
        two.next = one;
        detectCycle(one);
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return null;
        } else if (head == head.next) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick!=null && slow != null){
            if(quick == slow){
                break;
            }
            if(quick.next == null){
                return null;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        if(quick == null){
            return null;
        }
        slow = slow.next;
        while (head != slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
