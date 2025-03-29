package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 路径总和Ⅱ {
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
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        backsort(root, targetSum);
        return res;
    }

    private void backsort(TreeNode root, int targetSum) {
        if(root.val == targetSum && root.left == null && root.right == null){
            path.add(root.val);
            res.add((List<Integer>) path.clone());
            path.removeLast();
        }else{
            path.add(root.val);
            if(root.left != null) {
                backsort(root.left, targetSum - root.val);
            }
            if(root.right != null){
                backsort(root.right, targetSum - root.val);
            }
            path.removeLast();
        }
    }
}
