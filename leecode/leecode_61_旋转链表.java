package leecode;

public class leecode_61_旋转链表 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int nodeNumber = 0;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        head = dummyHead;
        while (head.next!= null){
            head = head.next;
            nodeNumber++;
        }
        k = k % nodeNumber;
        head = dummyHead;
        ListNode kth = dummyHead;
        while (k>0){
            head = head.next;
            k--;
        }
        while (head.next != null){
            head = head.next;
            kth = kth.next;
        }
        head.next = dummyHead.next;
        dummyHead.next = kth.next;
        kth.next = null;
        return dummyHead.next;
    }
}
