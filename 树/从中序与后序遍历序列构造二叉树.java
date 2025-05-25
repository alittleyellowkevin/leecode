package 树;

import java.util.Arrays;

public class 从中序与后序遍历序列构造二叉树 {
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
        int[] inorder = {9,3,15,20,7};
        int[] post = {9, 15, 7, 20, 3};
        buildTree(inorder, post);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }else {
            return build(inorder, postorder);
        }
    }

    private static TreeNode build(int[] mid, int[] post) {
        if (mid.length == 1) {
            return new TreeNode(mid[0]);
        } else {
            //首先取后序的最后一个元素
            int postLastOne = post[post.length - 1];
            // 找到这个元素在 中序 的位置
            int inorder_tag = find(mid, postLastOne);
            // 创建一个新节点这个节点的值等于postLastOne
            TreeNode head = new TreeNode(postLastOne);
            //左边节点的个数
            int left_size = inorder_tag - 0;
            //右边节点的个数
            int right_size = mid.length - inorder_tag - 1;

            if (left_size > 0) {
                head.left = build(Arrays.copyOfRange(mid, 0, 0 + left_size), Arrays.copyOfRange(post, 0, 0 + left_size));
            }
            if (right_size > 0) {
                head.right = build(Arrays.copyOfRange(mid, inorder_tag + 1, inorder_tag + 1 + right_size), Arrays.copyOfRange(post, left_size, post.length - 1));
            }
            return head;
        }
    }

    private static int find(int[] inorder, int postLast) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postLast) {
                return i;
            }
        }
        return -1;
    }
}
