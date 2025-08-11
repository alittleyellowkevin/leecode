package hotcode100;

import model.ListNode;

import java.util.List;

public class leecode_148_排序链表 {
    public ListNode sortList(ListNode head) {
        // 边界问题
        if(head == null || head.next == null){
            return head;
        }
        // 找到中点，并分为两个链表
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        //合并两个表
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode<>(0);
        ListNode pre = dummyHead;
        while (left != null && right != null){
//            if(left.val < right.val){
//                pre.next = left;
//                pre = left;
//                left = left.next;
//            }else {
//                pre.next = right;
//                pre = right;
//                right = right.next;
//            }
        }
        pre.next = left != null ? left : right;
        return dummyHead.next;
    }

    private ListNode findMid(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while(quick != null){
            if(quick.next != null){
                quick = quick.next.next;
                slow = slow.next;
            }else {
                return slow;
            }
        }
        return slow;
    }


}
