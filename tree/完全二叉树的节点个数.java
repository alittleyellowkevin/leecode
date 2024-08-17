package tree;

public class 完全二叉树的节点个数 {
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
    public int countNodes(TreeNode root) {
        int[] number = new int[1];
        number[0] = 0;
        count(root, number);
        return number[0];
    }

    private void count(TreeNode root, int[] number) {
        if(root!=null){
            number[0] += 1;
            count(root.left, number);
            count(root.right, number);
        }
    }
}
