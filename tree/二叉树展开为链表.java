package tree;

import java.util.Stack;

public class 二叉树展开为链表 {
    public class TreeNode {
                int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = new TreeNode();
        if(root == null){
            return;
        }
        pre.right = root;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode now = stack.pop();
            pre.right = now;
            pre.left = null;
            pre = now;
            if(now.right !=null){
                stack.push(now.right);
            }
            if(now.left != null){
                stack.push(now.left);
            }
        }
    }
}
