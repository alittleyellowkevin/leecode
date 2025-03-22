package linkList;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;
        if(head == null){
            return null;
        }
        while (head.next != null){
            ListNode cur = head.next;
            head.next = head.next.next;
            cur.next = dummy_head.next;
            dummy_head.next = cur;
        }
        return dummy_head.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
