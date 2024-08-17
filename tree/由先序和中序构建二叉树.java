package tree;

public class 由先序和中序构建二叉树 {
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
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, mid);
    }
    public static TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        return build(preOrder, vinOrder, 0, preOrder.length-1, 0, vinOrder.length-1);
    }

    private static TreeNode build(int[] preOrder, int[] midOrder, int preL, int preR, int midL, int midR){
        if(preL <= preR) {
            int k = find(preOrder[preL], midOrder, midL, midR);
            TreeNode node = new TreeNode(preOrder[preL]);
            int leftLength = k - midL;
            int rightLength = midR - k;
            node.left = build(preOrder, midOrder, preL + 1, preL+leftLength, midL, midL+leftLength-1);
            node.right = build(preOrder, midOrder, preL+leftLength+1, preR, k+1, midR);
            return node;
        }else {
            return null;
        }
    }

    public static int find(int number, int[] nums, int midL, int midR){
        for (int i = midL; i <= midR; i++) {
            if(number == nums[i]){
                return i;
            }
        }
        return 0;
    }
}
