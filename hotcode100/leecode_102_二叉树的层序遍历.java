package hotcode100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leecode_102_二叉树的层序遍历 {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
        if(root != null){
            nodeQueue.offer(root);
        }
        while (!nodeQueue.isEmpty()){
            int n = nodeQueue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<n; i++){
                TreeNode<Integer> curr = nodeQueue.poll();
                level.add(curr.val);
                if(curr.left != null){
                    nodeQueue.add(curr.left);
                }
                if(curr.right != null){
                    nodeQueue.add(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
