package hotcode100;

import model.TreeNode;

public class leecode_104_二叉树的最大深度 {
    int maxLength = 0;
    public int maxDepth(TreeNode<Integer> root) {
        if(root != null){
            pre(root, 1);
        }
        return maxLength;
    }

    public void pre(TreeNode<Integer> root, Integer depth){
        maxLength = Math.max(depth, maxLength);
        if(root.left != null){
            pre(root.left, depth+1);
        }
        if(root.right != null){
            pre(root.right, depth+1);
        }
    }
}
