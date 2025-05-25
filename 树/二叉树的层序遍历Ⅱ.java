package 树;

import java.util.*;

public class 二叉树的层序遍历Ⅱ {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode now = queue.poll();
                nodes.add(now.val);
                if(now.left != null) queue.add(now.left);
                if(now.right != null) queue.add(now.right);
            }
            stack.push(nodes);
        }
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            res.add(stack.pop());
        }
        return res;
    }
}
