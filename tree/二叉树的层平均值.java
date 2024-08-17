package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值 {
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            double number = 0;
            for (int i = 0; i < n; i++) {
                TreeNode now = queue.poll();
                if(i == n-1){
                    number += now.val;
                    res.add(number/n);
                }else {
                    number += now.val;
                }
                if(now.left != null) queue.add(now.left);
                if(now.right != null) queue.add(now.right);
            }
        }
        return res;
    }
}
