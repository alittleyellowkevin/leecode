package 链表;

public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        // write code here
        ListNode mid = head;
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        pre.next = head;
        while (mid != null) {
            if (mid.val == val) {
                pre.next = mid.next;
                break;
            }
            mid = mid.next;
            pre = pre.next;
        }
        return dummyHead.next;
    }
}
