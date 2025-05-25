package 树;

public class 先中后 {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.value + " ");
        preOrderRecur(head.right);
    }
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        preOrderRecur(head.left);
        System.out.println(head.value + " ");
        preOrderRecur(head.right);
    }
}
