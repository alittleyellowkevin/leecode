package tree;

import sort.插入排序;

public class 二叉搜索树中的插入操作 {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode pre = null;
            TreeNode now = root;
            if(root ==null){
                return new TreeNode(val);
            }
        while (now != null){
            if(now.val > val){
                pre = now;
               now = now.left;
            }else {
                pre = now;
                now = now.right;
            }
        }
        if(val > pre.val){
            pre.right = new TreeNode(val);
        }else {
            pre.left = new TreeNode(val);
        }
        return root;
    }
}
