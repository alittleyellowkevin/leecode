package linkList;

public class 删除链表的倒数第N个节点 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode pre = null;
        ListNode target = head;
        ListNode tail = head;
        while(n>0){
            tail = tail.next;
            n = n-1;
        }
        while(tail != null){
            pre = pre==null ? head : pre.next;
            target = target.next;
            tail = tail.next;
        }
        if(pre==null){
            ListNode res = new ListNode(target.next.val);
            res.next = target.next.next;
            return res;
        }else{
            pre.next = target.next;
        }
        return head;
    }
}
