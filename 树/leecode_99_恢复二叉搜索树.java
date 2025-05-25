package 树;

import java.util.LinkedList;
import java.util.Queue;

public class leecode_99_恢复二叉搜索树 {
    public static void main(String[] args) {
        leecode_99_恢复二叉搜索树 solution = new leecode_99_恢复二叉搜索树();
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(3);
        root.left.right = solution.new TreeNode(2);
        solution.recoverTree(root);
        System.out.println(root.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
    }

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

    public void recoverTree(TreeNode root) {
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode present = queue.poll();
                if (present.left != null) {
                    queue.add(present.left);
                }
                if (present.right != null) {
                    queue.add(present.right);
                }
                TreeNode leftMax = present.left == null ? present : findMax(present.left);
                TreeNode rightMin = present.right == null ? present : findMin(present.right);
                if (present.val < leftMax.val) {
                    int temp = present.val;
                    present.val = leftMax.val;
                    leftMax.val = temp;
                    return;
                }
                if (present.val > rightMin.val) {
                    int temp = present.val;
                    present.val = rightMin.val;
                    rightMin.val = temp;
                    return;
                }

            }
        }
    }

    public TreeNode findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
