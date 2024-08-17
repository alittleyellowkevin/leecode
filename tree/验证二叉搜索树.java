package tree;

import sort.插入排序;

public class 验证二叉搜索树 {
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
        TreeNode number1 = new TreeNode(2);
        TreeNode number2 = new TreeNode(1);
        TreeNode number3 = new TreeNode(3);
        number1.left = number2;
        number1.right = number3;
        isValidBST(number1);
    }
    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, Long min, Long max) {
        if(root.val<=max && root.val>=min){
            boolean flag = true;
            flag = flag && (root.left == null ? true:isValid(root.left, min, (long)root.val-1));
            flag = flag && (root.right == null ? true:isValid(root.right, (long)root.val+1, max));
            return flag;
        }else {
            return false;
        }
    }
}
