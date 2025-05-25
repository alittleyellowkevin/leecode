package 树;

import java.util.ArrayList;
import java.util.List;

public class 有序链表转换二叉搜索树 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return build(list, 0, list.size()-1);
    }

    private TreeNode build(List<Integer> list, int l, int r) {
          if(l <= r){
              int mid  = (l+r)/2;
              TreeNode node = new TreeNode(list.get(mid));
              node.left = build(list, l, mid-1);
              node.right = build(list, mid+1, r);
              return node;
          }
          return null;
    }
}
