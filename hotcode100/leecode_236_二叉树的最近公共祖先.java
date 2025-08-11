package hotcode100;

import model.TreeNode;

public class leecode_236_二叉树的最近公共祖先 {
    TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root != null){
            post(root, p, q);
        }
        return result;
    }

    private boolean post(TreeNode root, TreeNode p, TreeNode q) {
        boolean left = false;
        boolean right = false;
        if(root.left != null){
            left = post(root.left, p, q);
        }
        if(root.right != null){
            right = post(root.right, p, q);
        }
        int count = (root == p ? 1:0);
        count += (root == q ? 1:0);
        count += (left? 1:0);
        count += (right? 1:0);
        if(left && right || (count == 2)){
            result = root;
        }
        return root ==  p || root == q || left || right;
    }
}
