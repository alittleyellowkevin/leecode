package hotcode100;

import model.TreeNode;
import 链表.对链表进行插入排序;

import java.util.Arrays;

public class leecode_105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(Arrays.binarySearch(inorder, 0, 5, 3));
//        buildTree(new int[]{-1}, new int[]{-1});
    }

    int preNow = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(preNow >= inorder.length || inStart > inEnd){
            return null;
        }
        //首先获取当前元素，然后将此中序遍历化为两部分
        TreeNode root = new TreeNode(preorder[preNow]);
        int mid = -1;
        for(int i=inStart; i<= inEnd; i++){
            if(inorder[i] == preorder[preNow]){
                mid = i;
            }
        }
        preNow++;
        root.left = buildTree(preorder, inorder, inStart, mid-1);
        root.right = buildTree(preorder, inorder, mid + 1, inEnd);
        return root;
    }
}
