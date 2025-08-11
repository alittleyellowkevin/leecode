package hotcode100;

import model.TreeNode;

public class leecode_108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if(l > r){
            return null;
        } else {
            int mid = (l + r) / 2;
            TreeNode newNode = new TreeNode<>(nums[mid]);
            newNode.left = buildTree(nums, l, mid-1);
            newNode.right = buildTree(nums, mid+1, r);
            return newNode;
        }
    }
}
