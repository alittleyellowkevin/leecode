package hotcode100;

import model.ListNode;

import java.util.List;

public class leecode_206_反转链表 {
    public static void main(String[] args) {
        ListNode one = new ListNode<>(1);
        ListNode two =  new ListNode<>(2);
        ListNode three = new ListNode<>(3);
        ListNode four =  new ListNode<>(4);
        ListNode five = new ListNode<>(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        reverseList(one);
    }
    public static ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        while (head.next != null){
            ListNode node = head.next;
            head.next = node.next;
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        return dummyHead.next;
    }
}
