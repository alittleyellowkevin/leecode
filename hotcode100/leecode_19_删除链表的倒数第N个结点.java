package hotcode100;

import model.ListNode;

public class leecode_19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode tail = dummyHead;
        while (n>0){
            tail = tail.next;
            n--;
        }
        ListNode pre = dummyHead;
        while (tail.next!=null){
            tail = tail.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
