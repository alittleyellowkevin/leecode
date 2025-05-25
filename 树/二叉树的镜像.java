package 树;

import 排序.插入排序;

public class 二叉树的镜像 {
    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        eight.left = seven;
        seven.left = six;
        six.left = five;
        five.left = four;
        Mirror(eight);
    }
    public static TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null){
            return null;
        }
        change(pRoot);
        return pRoot;
    }

    private static void change(TreeNode root) {
        TreeNode mid = root.left;
        root.left = root.right;
        root.right = mid;
        if(root.left !=null){
            change(root.left);
        }
        if(root.right != null){
            change(root.right);
        }
    }
}
