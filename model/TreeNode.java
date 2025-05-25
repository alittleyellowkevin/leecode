package model;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T x) {
        val = x;
    }

    public TreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}
