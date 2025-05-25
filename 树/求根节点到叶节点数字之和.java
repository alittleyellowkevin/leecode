package 树;

import 排序.插入排序;

public class 求根节点到叶节点数字之和 {
    public class TreeNode {
              int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        backsort(root, 0);
        return sum;
    }

    private void backsort(TreeNode root, int path) {
        if(root.left == null && root.right == null){
            sum += path*10 + root.val;
        }else {
            if(root.left != null){
                backsort(root.left, path*10 + root.val);
            }
            if(root.right != null){
                backsort(root.right, path*10 + root.val);
            }
        }
    }
}
