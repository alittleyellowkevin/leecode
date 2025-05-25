package 树;

import java.util.LinkedList;
import java.util.Stack;

import 排序.插入排序;

public class BSTIterator {
    public class TreeNode {
                 int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
     int tag = 0;
     LinkedList<TreeNode> list = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        mid(root);
    }

    private void mid(TreeNode root) {
        if(root.left!= null){
            mid(root.left);
        }
        list.add(root);
        if(root.right != null){
            mid(root.right);
        }
    }

    public int next() {
        tag++;
        return list.get(tag-1).val;
    }

    public boolean hasNext() {
        if(tag+1>=list.size()){
            return false;
        }else {
            return true;
        }
    }
}
