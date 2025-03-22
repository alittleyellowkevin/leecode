package leecode;

public class leecode_83_删除排序链表中的重复元素 {
    public class ListNode {
                  int val;
          ListNode next;
          ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return null;
        ListNode pre = head;
        ListNode now = head.next;
        while (now!=null){
            while (now!=null && now.val == pre.val){
                now = now.next;
            }
            pre.next = now;
            if(now!=null)  now = now.next;
            pre = pre.next;
        }
        return head;
    }
}
