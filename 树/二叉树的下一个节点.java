package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import 排序.插入排序;

public class 二叉树的下一个节点 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    List<TreeLinkNode> treeLinkNodes = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = pNode;
        while (root.next!=null){
            root = root.next;
        }
        midSort(root);
        for (int i = 0; i < treeLinkNodes.size(); i++) {
            if(treeLinkNodes.get(i) == pNode && i != treeLinkNodes.size()-1){
                return treeLinkNodes.get(i+1);
            }
        }
        return null;
    }

    private void midSort(TreeLinkNode root) {
        if(root.left!=null)midSort(root.left);
        treeLinkNodes.add(root);
        if(root.right!=null)midSort(root.right);
    }
}
