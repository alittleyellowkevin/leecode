package tree;

import java.util.ArrayList;
import java.util.List;

public class N叉树的前序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private void pre(Node root, List<Integer> res) {
        if(root!= null){
            res.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                pre(root.children.get(i), res);
            }
        }
    }
}
