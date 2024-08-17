package tree;

public class 最大二叉树 {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }else {
            TreeNode head = build(nums, 0, nums.length-1);
            return head;
        }
    }

    private TreeNode build(int[] nums, int left, int right) {
        if(right-left == 0){
            return new TreeNode(nums[right]);
        }else {
            int max_tag = findMax(nums, left, right);
            TreeNode head = new TreeNode(nums[max_tag]);
            int leftSize = max_tag - left;
            int rightSize = right - max_tag;
            if(leftSize>0){
                head.left = build(nums, left,left+leftSize-1);
            }
            if(rightSize>0){
                head.right = build(nums, right-rightSize+1, right);
            }
            return head;
        }
    }

    private int findMax(int[] nums, int left, int right) {
        int max = nums[left];
        int max_tag = left;
        for (int i = left+1; i <= right; i++) {
            if(nums[i] > max){
                max = nums[i];
                max_tag = i;
            }
        }
        return max_tag;
    }
}
