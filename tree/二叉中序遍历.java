package tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉中序遍历 {
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
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         inoder(root, result);
         return result;

    }

    private void inoder(TreeNode root, List<Integer> result) {
         if(root ==null){
             return;
         }
         if(root.left != null){
             inoder(root.left, result);
         }
         result.add(root.val);
         if(root.right != null){
             inoder(root.right, result);
         }

    }
}
