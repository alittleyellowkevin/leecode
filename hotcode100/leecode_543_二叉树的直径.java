package hotcode100;

import model.TreeNode;

public class leecode_543_二叉树的直径 {
    int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        post(root);
        return maxLength;
    }

    private int post(TreeNode root) {
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = post(root.left) + 1;
        }
        if(root.right != null){
            rightHeight = post(root.right) + 1;
        }
        maxLength = Math.max(leftHeight + rightHeight, maxLength);
        return Math.max(leftHeight, rightHeight);
    }

}
