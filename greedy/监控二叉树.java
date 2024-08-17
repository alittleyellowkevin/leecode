package greedy;

import array.有效的完全平方数;
import sort.插入排序;
import tree.二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 监控二叉树 {
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

    public int minCameraCover(TreeNode root) {
        int count[] = new int[1];
        int rootTag = post(root, count);
        if( rootTag == 0){
            count[0]++;
        }
        return count[0];
    }

    // 0 无覆盖 ；1 有摄像头 ；2有覆盖
    private int post(TreeNode root, int[] count) {
        if(root == null){
            return 2;
        }
        int tagLeft = post(root.left, count);
        int tagRight = post(root.right, count);
        if(tagRight == 2 && tagLeft == 2){
            return 0;
        } else if (tagRight == 0 || tagLeft == 0) {
            count[0]++;
            return 1;
        } else {
            return 2;
        }
    }
}