package tree;

import sort.插入排序;

import javax.sound.midi.ControllerEventListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 恢复二叉搜索树 {
    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        three.left = one;
        three.right = four;
        four.left = two;
        recoverTree(three);
    }

    public static void recoverTree(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        mid(root, nodes);
        if(nodes.size() == 4){
            int mid = nodes.get(0).val;
            nodes.get(0).val = nodes.get(3).val;
            nodes.get(3).val = mid;
        }
        if(nodes.size() == 2 || nodes.size()==3){
            int mid = nodes.get(0).val;
            nodes.get(0).val = nodes.get(1).val;
            nodes.get(1).val = mid;
        }
    }

    private static void mid(TreeNode root, LinkedList<TreeNode> nodes) {
        if(root.left != null){
            mid(root.left, nodes);
        }

        if(nodes.isEmpty() || nodes.size() == 2){
            nodes.add(root);
        }else {
            if(root.val > nodes.getLast().val){
                nodes.removeLast();
                nodes.add(root);
            } else if (root.val < nodes.getLast().val) {
                nodes.add(root);
            }
        }

        if(root.right != null){
            mid(root.right, nodes);
        }

    }

}
