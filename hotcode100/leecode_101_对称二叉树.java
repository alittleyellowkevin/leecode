package hotcode100;

import model.TreeNode;

public class leecode_101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root != null){
            return checkSymmetric(root.left, root.right);
        }
        return true;
    }

    public boolean checkSymmetric(TreeNode left, TreeNode right) {
        if(left != null && right != null){
            if(left.val == right.val){
                return checkSymmetric(left.left, right.left) | checkSymmetric(left.right, right.right);
            }
            return false;
        } else if (left == null && right == null){
            return true;
        } else{
            return false;
        }
    }
}
