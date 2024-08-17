package tree;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.Stack;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        TreeNode ten = new TreeNode(10);
        TreeNode six = new TreeNode(6);
        TreeNode forteen = new TreeNode(14);
        ten.left = six;
        ten.right = forteen;
        Convert(ten);
    }
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    static TreeNode pre = null;
    static TreeNode res = null;
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || pRootOfTree != null) {
                if (pRootOfTree != null) {
                    stack.push(pRootOfTree);
                    pRootOfTree = pRootOfTree.left;
                } else {
                    pRootOfTree = stack.pop();
                    if(res == null){
                        res = pRootOfTree;
                    }
                    if(pre == null){
                        pRootOfTree.left = null;
                        pre = pRootOfTree;
                    }else {
                        pre.right = pRootOfTree;
                        pRootOfTree.left = pre;
                        pre = pRootOfTree;
                    }
                    pRootOfTree = pRootOfTree.right;
                }
            }
        }
        return res;
    }


}
