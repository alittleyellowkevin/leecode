package leecode;

public class leecode_21_合并两个有序链表 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode pre = dummyHead;
        while(l1 != null && l2!= null){
            if(l1.val >= l2.val){
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            pre.next = l1;
        }else {
            pre.next = l2;
        }
        return dummyHead.next;
    }
}
