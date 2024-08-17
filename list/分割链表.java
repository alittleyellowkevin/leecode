package list;

public class 分割链表 {
    public static void main(String[] args) {
//       ListNode seventh = new ListNode(5, null);
        ListNode sixth = new ListNode(2, null);
        ListNode fifth = new ListNode(5, sixth);
        ListNode forth = new ListNode(2, fifth);
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(4, third);
        ListNode first = new ListNode(1, second);
        partition(first, 3);
    }
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode partition(ListNode head, int x) {
        ListNode res = null;
        ListNode dayuhead = null;
        ListNode xiaoyu = null;
        ListNode daoyu = null;
        while (head != null){
            if(head.val < x){
                if(xiaoyu == null) {
                    ListNode node = new ListNode();
                    node.val = head.val;
                    xiaoyu = node;
                    res = node;
                }else {
                    ListNode node = new ListNode();
                    node.val = head.val;
                    xiaoyu.next = node;
                    xiaoyu = xiaoyu.next;
                }
            }else {
                if(daoyu == null){
                    ListNode node = new ListNode();
                    node.val = head.val;
                    daoyu = node;
                    dayuhead = daoyu;
                }else {
                    ListNode node = new ListNode();
                    node.val = head.val;
                    daoyu.next = node;
                    daoyu = daoyu.next;
                }
            }
            head = head.next;
        }
        if(xiaoyu != null){
        xiaoyu.next = dayuhead;}else {
            return dayuhead;
        }
        return res;
    }
}
