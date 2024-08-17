package tree;

import sort.插入排序;

public class 路径总和 {
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            }else {
                return findpath(root, targetSum);
            }
    }

        private boolean findpath(TreeNode root, int targetSum) {
            if(root == null){
                return targetSum == 0 ? true:false;
            } else {
                if(root.right == null && root.left == null){
                    return targetSum- root.val == 0 ? true:false;
                }
                return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
            }
        }
    }
}
