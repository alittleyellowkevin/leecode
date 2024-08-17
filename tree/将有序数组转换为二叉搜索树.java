package tree;

public class 将有序数组转换为二叉搜索树 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if(l<=r) {
            int mid = l+(r-l)/2;
            TreeNode root = new TreeNode(nums[mid]);
            if(mid-1>=l){
                root.left = buildTree(nums, l, mid-1);
            }
            if(mid+1<=r){
                root.right = buildTree(nums, mid+1, r);
            }
            return root;
        }
        return null;
    }
}
