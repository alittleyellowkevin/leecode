package leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leecode_23_合成K个升序链表 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<ListNode> result = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            result.add(lists[i]);
        }
        if(result.size()==0){
            return null;
        }
        while (result.size() != 1){
            ListNode mid = mergeTwoLists(result.get(0), result.get(1));
            result.removeFirst();
            result.removeFirst();
            result.add(mid);
        }
        return result.get(0);
    }
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
