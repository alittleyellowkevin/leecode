package 树;

public class 平衡二叉树 {
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
    public boolean isBalanced(TreeNode root) {
        if(root!=null){
            int left = maxHeight(root.left);
            int right = maxHeight(root.right);
            if(left > right+1 || right > left+1){
                return false;
            }else {
                return isBalanced(root.left)&&isBalanced(root.right);
            }
        }else {
            return true;
        }
    }

    private int maxHeight(TreeNode root) {
         if(root == null){
             return 0;
         }else {
             return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
         }
    }
//    public boolean isBalanced(TreeNode root) {
//         if(root != null){
//             int right = maxDepth(root.right);
//             int left = maxDepth(root.left);
//
//             if(right - left > 1 || right-left < -1){
//                 return false;
//             }else{
//                 return isBalanced(root.right) && isBalanced(root.left);
//             }
//         }else {
//             return true;
//         }
//    }
//    public int maxDepth(TreeNode root) {
////        if(root == null){
////            return 0;
////        }
////        else {
////            int left = maxDepth(root.left);
////            int right = maxDepth(root.right);
////            int max = Math.max(left, right);
//            return max + 1;
//        }
//    }
}
