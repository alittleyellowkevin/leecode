package hotcode100;

import model.TreeNode;

public class leecode_226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            post(root);
        }
        return root;
    }

    private TreeNode post(TreeNode root) {
        TreeNode left=null;
        TreeNode right=null;
        if(root.left != null){
            left = post(root.left);
        }
        if(root.right != null){
            right = post(root.right);
        }
        root.left = right;
        root.right = left;
        return root;
    }
}
