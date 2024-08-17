package tree;

import sort.插入排序;

public class 二叉搜索树中的搜索 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val>val){
            if(root.left != null) {
                return searchBST(root.left, val);
            }else {
                return null;
            }
        }else if(root.val<val){
            if(root.right !=null){
                return searchBST(root.right, val);
            }else {
                return null;
            }
        }else {
            return root;
        }
    }
}
