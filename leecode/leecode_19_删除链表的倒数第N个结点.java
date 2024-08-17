package leecode;

import java.util.List;

public class leecode_19_删除链表的倒数第N个结点 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode tail = dummyHead;
        while (n>0){
            tail = tail.next;
            n--;
        }
        while (tail.next != null){
            pre = pre.next;
            tail = tail.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
