package 树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {
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

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorder(res, root);
            return res;
        }

        private void preorder(List<Integer> res, TreeNode root) {
            if(root == null){
                return;
            }else {
                res.add(root.val);
                preorder(res, root.left);
                preorder(res, root.right);
            }
        }
    }
}