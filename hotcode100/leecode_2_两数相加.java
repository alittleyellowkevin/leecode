package hotcode100;

import model.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class leecode_2_两数相加 {
    public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        int reserver = 0;
        while (l1 != null || l2 != null){
            int l1Number = l1 == null? 0:l1.val;
            int l2Number = l2 == null? 0:l2.val;
            reserver = (l1Number + l2Number + reserver)/10;
            int value = (l1Number + l2Number + reserver)%10;
            ListNode newNode = new ListNode<>(value);
            tail.next = newNode;
            tail = tail.next;
        }
        if(reserver != 0){
            tail.next = new ListNode<>(1);
        }
        return dummyHead.next;
    }
}
