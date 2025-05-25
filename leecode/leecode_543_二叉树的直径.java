package leecode;

import model.TreeNode;

public class leecode_543_二叉树的直径 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[]{0};
        post(root, max);
        return max[0];
    }

    public int post(TreeNode root, int[] max) {
        int leftdepth = 0;
        int rightdepth = 0;
        if(root.left != null){
            leftdepth = post(root.left, max);
        }
        if(root.right != null){
            rightdepth = post(root.right, max);
        }
        max[0] = Math.max(max[0], leftdepth + rightdepth + 1);
        return Math.max(1+leftdepth, 1+rightdepth);
    }
}
