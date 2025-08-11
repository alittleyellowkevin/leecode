package hotcode100;

import model.TreeNode;
import 链表.对链表进行插入排序;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Queue;


public class leecode_437_路径总和Ⅲ {
    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> pathMap = new HashMap<>();
        pathMap.put(0L, 1);
        long[] path = {0L};
        if(root != null) {
            pre(root, targetSum, pathMap, path);
        }
        return result;
    }

    private void pre(TreeNode<Integer> root, int targetSum, HashMap<Long, Integer> pathMap, long[] path) {
        path[0] += root.val;
        long target = path[0] - targetSum;
        result += pathMap.getOrDefault(target, 0);
        pathMap.put(path[0], pathMap.getOrDefault(path[0], 0)+1);
        if(root.left != null){
            pre(root.left, targetSum, pathMap, path);
        }
        if(root.right != null){
            pre(root.right, targetSum, pathMap, path);
        }
        pathMap.put(path[0], pathMap.getOrDefault(path[0], 0)-1);
        path[0] -= root.val;
    }
}
