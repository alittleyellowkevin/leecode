package tree;

public class 翻转二叉树 {
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
    public TreeNode invertTree(TreeNode root) {
        if(root!= null){
            TreeNode mid = root.right;
            root.right = root.left;
            root.left = mid;
            if(root.left!= null)invertTree(root.left);
            if(root.right!=null)invertTree(root.right);
        }
        return root;
    }
}
