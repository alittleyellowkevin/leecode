package tree;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        int flag = 0;
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode now = queue.poll();
                nodes.add(now.val);
                if(now.left != null) queue.add(now.left);
                if(now.right != null) queue.add(now.right);
            }
            if(flag % 2 == 1){
                Collections.reverse(nodes);
            }
            flag++;
            res.add(nodes);
        }
        return res;
    }
}
