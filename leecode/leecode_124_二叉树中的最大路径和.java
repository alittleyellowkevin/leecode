package leecode;

public class leecode_124_二叉树中的最大路径和 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        mid(root, max);
        return max[0];
    }

    private int[] mid(TreeNode root, int[] max) {
        int[] left = new int[]{0, 0};
        int[] right = new int[]{0, 0};
        if(root.left != null){
            left = mid(root.left, max);
        }
        if(root.right != null){
            right = mid(root.right, max);
        }
        int[] res = new int[]{0, 0};
        res[0] = Math.max(root.val, root.val + Math.max(left[0], left[1]));
        res[1] = Math.max(root.val, root.val + Math.max(right[0], right[1]));
        max[0] = Math.max(max[0], Math.max(res[1], Math.max(res[0]+res[1]-root.val, res[0])));
        return res;
    }
}
