package linkList;

public class 两数相加 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int flag = 0;
        while (l1!=null || l2!=null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            tail.next = new ListNode((a+b+flag)%10);
            tail = tail.next;
            flag = (a+b+flag) > 9? 1:0;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if(flag == 1){
            tail.next = new ListNode(1);
        }
        return head.next;
    }

}
