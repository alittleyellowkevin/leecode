package hotcode100;

import model.TreeNode;

public class leecode_114_二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode one = new TreeNode<>(1);
        TreeNode two = new TreeNode<>(2);
        TreeNode three = new TreeNode<>(3);
        TreeNode four = new TreeNode<>(4);
        TreeNode five = new TreeNode<>(5);
        TreeNode six = new TreeNode<>(6);
        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.right = six;
        flatten(one);
    }
    public static void flatten(TreeNode root) {
        if(root != null) {
            post(root);
        }
        return;
    }

    private static TreeNode[] post(TreeNode root) {
        TreeNode[] leftNode = null;
        TreeNode[] rightNode = null;
        if(root.left != null){
            leftNode = post(root.left);
        }
        if(root.right != null){
            rightNode = post(root.right);
        }
        if(leftNode == null && rightNode == null){
            return new TreeNode[]{root, root};
        }
        if(leftNode != null && rightNode == null){
            root.right = leftNode[0];
            root.left = null;
            return new TreeNode[]{root, leftNode[1]};
        }
        if(leftNode ==null && rightNode != null){
            return new TreeNode[]{root, rightNode[1]};
        }else {
            root.right = leftNode[0];
            root.left = null;
            leftNode[1].right = rightNode[0];
            return new TreeNode[]{root, rightNode[1]};
        }
    }
}
