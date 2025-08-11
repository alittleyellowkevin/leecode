package hotcode100;

import model.TreeNode;


public class leecode_230_二叉搜索树中第K小的元素 {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        if(root != null){
            mid(root);
        }
        return result;
    }

    private void mid(TreeNode<Integer> root) {
        if(root.left != null){
            mid(root.left);
        }
        count--;
        if(count == 0){
            result = root.val;
        }
        if(root.right != null){
            mid(root.right);
        }
    }
}
