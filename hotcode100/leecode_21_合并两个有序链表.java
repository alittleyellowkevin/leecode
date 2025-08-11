package hotcode100;

import model.ListNode;

public class leecode_21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode dummyHead = new ListNode<>();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null){
            if(list1.val<list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = list1==null?list2:list1;
        return dummyHead.next;
    }
}
