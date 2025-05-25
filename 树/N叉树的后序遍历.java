package 树;

import java.util.ArrayList;
import java.util.List;

public class N叉树的后序遍历 {
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        post(root, res);
        return res;
    }

    private void post(Node root, List<Integer> res) {
        if(root!= null){
            for (int i = 0; i < root.children.size(); i++) {
                post(root.children.get(i), res);
            }
            res.add(root.val);
        }
    }
}
