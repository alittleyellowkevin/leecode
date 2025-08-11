package hotcode100;

import model.ListNode;

public class leecode_160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode node = new ListNode<>();
        node = headA;
        while (node.next != null){
            lenA++;
            node = node.next;
        }
        node = headB;
        while (node.next != null){
            lenB++;
            node = node.next;
        }
        if(lenA > lenB){
            for(int i=0; i<lenA-lenB; i++){
                headA = headA.next;
            }
        } else{
            for(int i=0; i<lenB - lenA; i++){
                headB = headB.next;
            }
        }
        while (headA != null){
            if(headA == headB){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
