package linkList;

public class 旋转链表 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode start = head;
        ListNode end = head;
        int count = 1;
        while (end.next!= null){
            end = end.next;
            count = count+1;
        }
        end = head;
        k = k % count;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        while(end.next!=null){
            start = start.next;
            end = end.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;
        return head;
    }
}
