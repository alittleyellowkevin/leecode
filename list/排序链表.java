package list;

import tree.修剪二叉搜索树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 排序链表 {
    public ListNode sortList(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode node = head;
        while (node!=null){
            list.add(node.val);
            node = node.next;
        }
        list.sort((a,b)-> a - b);
        node = head;
        while (node!=null){
            node.val = list.getFirst();
            list.removeFirst();
            node = node.next;
        }
        return head;
    }

}
