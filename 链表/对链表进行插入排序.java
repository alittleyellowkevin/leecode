package 链表;

public class 对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        for (int i = 0; i < count - 1; i++) {
            node = dummyHead;
            while (node.next != null && node.next.next != null) {
                if (node.next.val > node.next.next.val) {
                    swap(node);
                }
                node = node.next;
            }
        }
        return dummyHead.next;
    }

    private void swap(ListNode node) {
        ListNode nextNext = node.next.next;
        node.next.next = node.next.next.next;
        nextNext.next = node.next;
        node.next = nextNext;
    }
}
