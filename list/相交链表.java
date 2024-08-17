package list;

public class 相交链表 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int count1 = 0;
         ListNode l1 = headA;
         ListNode l2 = headB;
         int count2 = 0;
         while(l1 != null || l2 != null){
             if(l1 != null){
                 count1++;
                 l1 = l1.next;
             }
             if(l2 != null){
                 count2++;
                 l2 = l2.next;
             }
         }
         l1 = headA;
         l2 = headB;
         if(count1 > count2){
             for (int i = 0; i < count1-count2; i++) {
                 l1 = l1.next;
             }
         }else{
             for (int i=0; i<count2-count1; i++){
                 l2 = l2.next;
             }
         }
         while(l1 !=null && l2!=null){
             if(l1 == l2){
                 return l1;
             }else {
                 l1 = l1.next;
                 l2 = l2.next;
             }
         }
         return null;
    }
}

