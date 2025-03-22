package linkList;


public class 合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode end = head;
        ListNode l1 = list1;
        ListNode l2 = list2;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l2.val>l1.val){
            head.val = l1.val;
            l1 = l1.next;
        }else {
            head.val = l2.val;
            l2 = l2.next;
        }
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                ListNode node = new ListNode();
                end.next = node;
                end = node;
                node.val = l2.val;
                l2 = l2.next;
            }
            else {
                ListNode node = new ListNode();
                end.next = node;
                end = node;
                node.val = l1.val;
                l1 = l1.next;
            }
        }
        while (l1 != null){
            ListNode node = new ListNode();
            end.next = node;
            end = node;
            node.val = l1.val;
            l1 = l1.next;
        }while (l2 != null){
            ListNode node = new ListNode();
            end.next = node;
            end = node;
            node.val = l2.val;
            l2 = l2.next;
        }

        return head;
    }
}
