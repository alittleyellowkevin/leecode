package hotcode100;

import model.ListNode;

public class leecode_24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode<>();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = head;
        ListNode after = head.next;
        while (after != null){
            pre.next = after;
            mid.next = after.next;
            after.next = mid;
            after = mid;
            mid = pre.next;
            if(after.next == null || after.next.next == null){
                return dummyHead.next;
            }
            pre = pre.next.next;
            mid = mid.next.next;
            after = after.next.next;
        }
        return dummyHead.next;
    }
}
