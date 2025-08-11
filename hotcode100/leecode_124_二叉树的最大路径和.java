package hotcode100;

import model.TreeNode;

public class leecode_124_二叉树的最大路径和 {
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root != null){
            post(root);
        }
        return maxPathSum;
    }

    private int post(TreeNode<Integer> root) {
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = post(root.left);
        }
        if(root.right != null){
            right = post(root.right);
        }
        int temMax1 = Math.max(left + root.val, right + root.val);
        int temMax2 = Math.max(root.val, left + root.val + right);
        maxPathSum = Math.max(maxPathSum, Math.max(temMax1, temMax2));
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }
}
