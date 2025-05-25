package 链表;

import java.util.LinkedList;

public class 重排链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head.next == null || head == null) {
            return;
        }
        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode slow = head;
        ListNode fast = head;

        int size = 0;
        while (fast != null) {
            stack.push(fast);
            fast = fast.next;
            size++;
        }

        int time = 0;
        while (slow != null && time <= size / 2) {
            ListNode temp = slow.next;
            ListNode pop = stack.pop();
            slow.next = pop;
            pop.next = temp;

            slow = slow.next.next;
            time++;
        }

        slow.next = null;
    }
}
