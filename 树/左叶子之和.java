package 树;

import java.util.Properties;

public class 左叶子之和 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            int[] number = new int[1];
            pre(root, number, false);
            return number[0];
        }
    }

    private void pre(TreeNode root, int[] number, boolean flag) {
        if(root.left == null && root.right == null && flag){
            number[0] += root.val;
        }else {
            if(root.left != null){
                pre(root.left, number, true);
            }
            if(root.right != null){
                pre(root.right.left, number, false);
            }
        }
    }
}
