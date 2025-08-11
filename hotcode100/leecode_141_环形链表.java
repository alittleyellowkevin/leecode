package hotcode100;

import model.ListNode;

public class leecode_141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
            return false;
        } else if (head == head.next) {
            return true;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick!=null && slow != null){
            if(quick == slow){
                return true;
            }
            if(quick.next == null){
                return false;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }
}
