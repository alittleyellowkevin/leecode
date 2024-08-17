package leecode;

public class leecode_2_两数相加 {

    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int step = 0;
        ListNode tail  = new ListNode();
        ListNode head = tail;
        while (l1 != null || l2!=null || step != 0){
            int number1 = l1 == null? 0 : l1.val;
            int number2 = l2 == null? 0 : l2.val;
            int val = (step + number2 + number1) % 10;
            step = (step + number2 + number1)/10;
            tail.next = new ListNode(val);
            tail = tail.next;
            l1 = l1 == null? l1 :l1.next;
            l2 = l2 == null? l2 :l2.next;
        }
        return head.next;
    }
}
