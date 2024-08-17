package tree;

import sort.插入排序;

public class 把二叉搜索树转换为累加树 {
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
    public TreeNode convertBST(TreeNode root) {
        int[] number = new int[1];
        if(root ==null){
            return root;
        }
        midReverse(root, number);
        return root;
    }

    private void midReverse(TreeNode root, int[] number) {
        if(root.right != null){
            midReverse(root.right, number);
        }
        number[0] += root.val;
        root.val = number[0];
        if(root.left !=null){
            midReverse(root.left, number);
        }
    }
}
