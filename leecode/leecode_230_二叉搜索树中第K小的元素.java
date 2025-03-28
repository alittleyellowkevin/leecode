package leecode;

public class leecode_230_二叉搜索树中第K小的元素 {
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

    public static void main(String[] args) {
        leecode_230_二叉搜索树中第K小的元素 leecode_230_二叉搜索树中第K小的元素 = new leecode_230_二叉搜索树中第K小的元素();
        TreeNode root = leecode_230_二叉搜索树中第K小的元素.new TreeNode(3);
        TreeNode left = leecode_230_二叉搜索树中第K小的元素.new TreeNode(1);
        TreeNode right = leecode_230_二叉搜索树中第K小的元素.new TreeNode(4);
        TreeNode leftRight = leecode_230_二叉搜索树中第K小的元素.new TreeNode(2);
        root.left = left;
        root.right = right;
        left.right = leftRight;
        leecode_230_二叉搜索树中第K小的元素.kthSmallest(root, 1);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{1};
        int[] res = new int[1];
        mid(root, k, res, count);
        return res[0];
    }
    public void mid(TreeNode root, int k, int[] res, int[] count) {
        if(root.left != null){
            mid(root.left, k, res, count);
        }
        if(count[0] == k){
            res[0] = root.val;
        }
        count[0]++;
        if(root.right != null){
            mid(root.right, k, res, count);
        }
    }
}
