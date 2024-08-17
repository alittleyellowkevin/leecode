package tree;

import sort.插入排序;

public class 二叉搜索树的最小绝对差 {
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
        TreeNode number1 = new TreeNode(4);
        TreeNode number2 = new TreeNode(2);
        TreeNode number3 = new TreeNode(6);
        TreeNode number4 = new TreeNode(1);
        TreeNode number5 = new TreeNode(3);
        TreeNode number6 = new TreeNode(3);
        number1.left = number2;
        number1.right = number3;
        number2.left = number4;
        number2.right = number5;
        number1.right = number3;
        getMinimumDifference(number1);
    }

    public static int getMinimumDifference(TreeNode root) {
        int[] res = new int[]{Integer.MAX_VALUE};
        int max = 200000;
        int min = -200000;
        getMin(root, min, max, res);
        return res[0];
    }

    private static void getMin(TreeNode root, int min, int max, int[] res) {
        res[0] = Math.min(res[0],Math.min(root.val-min, max - root.val));
        if(root.left != null){
            getMin(root.left, min, root.val, res);
        }
        if(root.right != null){
            getMin(root.right, root.val, max, res);
        }
    }
}
