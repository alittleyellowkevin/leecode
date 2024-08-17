package list;

public class 环形链表 {
      class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public boolean hasCycle(ListNode head) {
        ListNode two = head;
        ListNode one = head;
        Boolean result = false;
        while(one!=null && two!= null){
            if(one == two){
                result = true;
                break;
            }
            one = one.next;
            two = two.next;
            if(two != null){
                two = two.next;
            }else {
                break;
            }
        }
        return result;
    }
}
