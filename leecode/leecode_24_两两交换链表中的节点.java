package leecode;

public class leecode_24_两两交换链表中的节点 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode pre = dummyHead;
        pre.next = head;
        ListNode mid = head;
        if(head == null){
            return null;
        }
        ListNode late = head.next;
        while (late != null){
            ListNode temp = late.next;
            pre.next = late;
            late.next = mid;
            mid.next = temp;
            temp = late;
            late = mid;
            mid = temp;
            if(late.next != null){
                pre = pre.next;
                mid = mid.next;
                late = late.next;
            }else {
                break;
            }
            if(late.next != null){
                pre = pre.next;
                mid = mid.next;
                late = late.next;
            }else {
                break;
            }
        }
        return dummyHead.next;
    }
}
