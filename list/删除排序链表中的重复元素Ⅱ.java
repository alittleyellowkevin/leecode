package list;

import java.util.List;

public class 删除排序链表中的重复元素Ⅱ {

    public static void main(String[] args) {
//        ListNode seventh = new ListNode(5, null);
//        ListNode sixth = new ListNode(4, seventh);
//        ListNode fifth = new ListNode(4, sixth);
//        ListNode forth = new ListNode(3, fifth);
        ListNode third = new ListNode(2, null);
        ListNode second = new ListNode(1, third);
        ListNode first = new ListNode(1, second);

        deleteDuplicates(first);
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = null;
        ListNode tail = res;
        ListNode zuo = head;
        ListNode zhong;
        ListNode you;
        if(head == null){
            return null;
        }else {
            zuo = head;
        }
        if(head.next != null){
            zhong = head.next;
        }else {
            return head;
        }
        if(head.next.next != null){
            you = head.next.next;
        }else {
            if(head.val == head.next.val){
                return null;
            }else {
                return head;
            }
        }

        if(head.val != head.next.val){
            ListNode node = new ListNode(head.val, null);
            res = node;
            tail = res;
        }
        while (you != null){
            if(zuo.val != zhong.val && zhong.val != you.val){
                if(res == null){
                    ListNode node = new ListNode(zhong.val, null);
                    res = node;
                    tail = res;
                }else {
                    ListNode node = new ListNode(zhong.val, null);
                    tail.next = node;
                    tail = tail.next;
                }
            }
            zuo = zuo.next;
            zhong = zhong.next;
            you = you.next;
        }
        if(zhong.val != zuo.val){
            if(res == null){
                ListNode node = new ListNode(zhong.val, null);
                res = node;
                tail = res;
            }else {
                ListNode node = new ListNode(zhong.val, null);
                tail.next = node;
                tail = tail.next;
            }
        }
        return res;
    }
}
