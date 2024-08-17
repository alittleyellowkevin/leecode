package tree;

public class 合并二叉树 {
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode head = build(root1, root2);
        return head;
    }

    private TreeNode build(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        } else if (root2 == null) {
            return root1;
        } else if (root1 == null) {
            return root2;
        }else {
            TreeNode head = new TreeNode(root1.val+root2.val);
            head.left = build(root1.left, root2.left);
            head.right = build(root1.right, root2.right);
            return head;
        }
    }
}
