package 树;


import java.util.ArrayList;
import java.util.List;

public class 树的子结构 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 ==null){
            return false;
        }
        if(IsSon(root1, root2)){
            return true;
        }
        boolean flag = false;
        if(root1.left!=null){
            flag = flag || HasSubtree(root1.left, root2);
        }
        if(root1.right!=null){
            flag = flag || HasSubtree(root1.right, root2);
        }
        return flag;
    }

    private boolean IsSon(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 ==null){
            return true;
        }
        if(root1 != null && root2 != null && root1.val == root2.val){
            return (root2.left != null? IsSon(root1.left, root2.left):true) && (root2.right != null? IsSon(root1.right, root2.right):true);
        }
        return false;
    }

}
