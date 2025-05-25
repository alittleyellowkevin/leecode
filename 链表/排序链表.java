package 链表;

import java.util.LinkedList;

public class 排序链表 {
    public ListNode sortList(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        list.sort((a, b) -> a - b);
        node = head;
        while (node != null) {
            node.val = list.getFirst();
            list.removeFirst();
            node = node.next;
        }
        return head;
    }

}
