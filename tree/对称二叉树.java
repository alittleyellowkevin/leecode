package tree;

import sort.插入排序;

public class 对称二叉树 {
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return compare(root.left, root.right);
        }
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right != null){
            return false;
        } else if (left !=null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }else {
            if(left.val == right.val){
                return compare(left.left, right.right) && compare(left.right, right.left);
            }else {
                return false;
            }
        }
    }

//    public boolean isSymmetric(TreeNode root) {
//        if(root == null){
//            return true;
//        } else if (root.left != null && root.right != null){
//            return isSym(root.left, root.right);
//        } else {
//            return false;
//        }
//    }
//
//    private boolean isSym(TreeNode left, TreeNode right) {
//        if(left!= null && right!= null)
//        {
//            if(left.val == right.val){
//                return isSym(left.left, right.left) && isSym(left.right,right.right);
//            }else {
//                return false;
//            }
//        } else if (left ==null && right == null) {
//            return true;
//        }else {
//            return false;
//        }
//
//    }
}
