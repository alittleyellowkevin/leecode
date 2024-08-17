package list;


public class 删除排序链表中的重复元素 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode deleteDuplicates(ListNode head) {
         if(head == null || head.next == null){
             return head;
         }
         ListNode next = head.next;
         ListNode present =  head;
         while(next.next != null){
             if(present.val == next.val){
                 present.next = next.next;
                 next = present.next;
             }else {
                 present = present.next;
                 next = next.next;
             }
         }
         if(present.val == next.val){
             present.next = null;
         }
         return head;
    }
}
