package linkList;

public class 反转链表Ⅱ {
    public static void main(String[] args) {
//        ListNode seventh = new ListNode(5, null);
//        ListNode sixth = new ListNode(4, seventh);
//        ListNode fifth = new ListNode(5, null);
//       ListNode forth = new ListNode(4, fifth);
//        ListNode third = new ListNode(3, forth);
//        ListNode second = new ListNode(2, third);
//        ListNode first = new ListNode(1, second);
//        reverseBetween(first, 2, 4);

    }
      public static class ListNode {
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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int n =  right - left;
        if(n == 0){
            return head;
        }
        ListNode pre = null;
        ListNode left_node = head;
        while (left != 1){
            if(pre == null){
                pre = left_node;
            }else {
                pre = pre.next;
            }
            left_node = left_node.next;
            left -= 1;
        }
        ListNode right_node = left_node.next;
        ListNode right_pre = left_node;


        for (int i = 0; i < n; i++) {
            if(pre == null){
                right_pre.next = right_node.next;
                right_node.next = left_node;
                ListNode mid = right_node;
                right_node = right_pre.next;
                left_node = mid;
            }else {
                right_pre.next = right_node.next;
                pre.next = right_node;
                right_node.next = left_node;
                right_node = right_pre.next;
                left_node = pre.next;
            }
        }
        if(pre == null){
            return left_node;
        }else {
        return head;
        }
    }
}
