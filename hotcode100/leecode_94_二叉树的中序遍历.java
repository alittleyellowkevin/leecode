package hotcode100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class leecode_94_二叉树的中序遍历 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode<Integer> root) {
        if(root != null){
            mid(root);
        }
        return list;
    }
    public void mid(TreeNode<Integer> root){
        if(root.left != null){
            mid(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            mid(root.right);
        }
    }
}
