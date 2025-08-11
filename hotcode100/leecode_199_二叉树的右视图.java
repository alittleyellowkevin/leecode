package hotcode100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leecode_199_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode<Integer> pollNode = queue.poll();
                if(i == n-1){
                    result.add(pollNode.val);
                }
                if(pollNode.left != null){
                    queue.add(pollNode.left);
                }
                if(pollNode.right != null){
                    queue.add(pollNode.right);
                }
            }
        }
        return result;
    }
}
