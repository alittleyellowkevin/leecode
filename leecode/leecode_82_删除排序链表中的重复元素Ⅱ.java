package leecode;

public class leecode_82_删除排序链表中的重复元素Ⅱ {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode deleteDuplicates(ListNode head) {
          ListNode dummyHead = new ListNode(0, head);
          ListNode cur = dummyHead;
          while (cur.next != null && cur.next.next != null){
              if(cur.next.val == cur.next.next.val){
                  int x = cur.next.val;
                  ListNode next = cur.next.next;
                  while (next != null && next.val == x){
                      next = next.next;
                  }
                  cur.next = next;
              }else {
                  cur = cur.next;
              }
          }
          return dummyHead.next;
    }
}
