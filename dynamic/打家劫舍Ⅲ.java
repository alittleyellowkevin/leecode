package dynamic;

import tree.二叉中序遍历;

public class 打家劫舍Ⅲ {
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
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(3);
        one.left = two;
        two.left = three;
        three.left = four;
        rob(one);
    }
    public static int rob(TreeNode root) {
        int[] two = backsort(root);
        System.out.println(Math.max(two[0], two[1]));
        return 1;
    }

    private static int[] backsort(TreeNode root) {
        if(root == null){
            return new int[]{0, 0};
        }
        int[] left = backsort(root.left);
        int[] right = backsort(root.right);
        //不取
        int notTake = Math.max(left[1] + right[1], left[0]+right[0]);
        notTake = Math.max(notTake, left[1]+right[0]);
        notTake = Math.max(notTake, left[0] + right[1]);
        //取
        int take = left[0] + right[0] + root.val;
        return new int[]{notTake, take};
    }
}
