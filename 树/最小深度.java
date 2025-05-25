package 树;

import 排序.插入排序;

public class 最小深度 {
    public class TreeNode {
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

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            if(root.left == null && root.right == null){
                return 1;
            }else if(root.left != null && root.right != null){
                int l = minDepth(root.left);
                int r = minDepth(root.right);
                int min = Math.min(l, r);
                return min + 1;
            }else{
                if(root.left!=null){
                    return 1+minDepth(root.left);
                }else{
                    return 1+minDepth(root.right);
                }
            }
        }
    }

}
