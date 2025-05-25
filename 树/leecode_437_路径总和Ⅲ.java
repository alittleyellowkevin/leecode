package 树;

import java.util.HashMap;

import model.TreeNode;

public class leecode_437_路径总和Ⅲ {
    public int pathSum(TreeNode<Long> root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return pre(root, targetSum, 0, prefix);
    }

    private int pre(TreeNode<Long> root, int targetSum,long cur, HashMap<Long, Integer> prefix) {
        if(root == null){
            return 0;
        }
        cur += root.val;
        int res = prefix.getOrDefault(cur - targetSum, 0); //获取前一个节点
        prefix.put(cur - targetSum, prefix.getOrDefault(cur, 0) + 1);
        res += pre(root.left, targetSum, cur, prefix);
        res += pre(root.right, targetSum, cur, prefix);
        prefix.put(cur, prefix.get(cur) - 1);
        return res;
    }
}
