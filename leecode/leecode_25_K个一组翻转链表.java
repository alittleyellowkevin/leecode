package leecode;

public class leecode_25_K个一组翻转链表 {
      public static class ListNode {
          int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode mid = dummyHead.next;
        ListNode tail = dummyHead;
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }
        while (tail!=null){
            ListNode tempTail = tail;
            ListNode tempMid = mid;
            for (int i = 0; i < k-1; i++) {
                pre.next = mid.next;
                mid.next = tail.next;
                tail.next = mid;
                mid = pre.next;
            }
            mid = tempTail;
            tail = tempMid;
            for (int i = 0; i < k; i++) {
                if(tail != null){
                    pre = pre.next;
                    mid = mid.next;
                    tail = tail.next;
                }else {
                    break;
                }
            }
        }
        return dummyHead.next;
    }
}
