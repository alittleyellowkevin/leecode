package hotcode100;

import model.ListNode;

public class leecode_25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyhead = new ListNode<>();
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode mid = head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail != null){
                tail = tail.next;
            }else {
                return dummyhead.next;
            }
        }
        return null;
    }
}
