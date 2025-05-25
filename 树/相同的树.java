package 树;

public class 相同的树 {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
          if(p != null && q!=null){
              if(p.val == q.val){
                  Boolean is1 = isSameTree(p.left, q.left);
                  Boolean is2 = isSameTree(p.right, q.right);
                  return is1 && is2;
              }else {
                  return false;
              }
          } else if (p ==null && q==null) {
              return true;
          }else {
              return false;
          }
    }
  }
}
