package hotcode100;

import model.TreeNode;

public class leecode_98_验证二叉搜索树 {
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        if(root != null){
            post(root);
        }
        return result;
    }

    private int[] post(TreeNode<Integer> root) {
        int[] left = null;
        int[] right = null;
        if(root.left != null){
            left = post(root.left);
        }
        if(root.right != null){
            right = post(root.right);
        }
        if(left != null){
            if(left[1] >= root.val) {
                result = false;
            }
        }else {
            left = new int[]{root.val, root.val};
        }
        if(right != null){
            if(right[0] <= root.val){
                result = false;
            }
        }else{
            right = new int[]{root.val, root.val};
        }
        return new int[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])};
    }
}
