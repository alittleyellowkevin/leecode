package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N叉树的层序遍历 {
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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node now = queue.poll();
                nodes.add(now.val);
                for (int j = 0; j < now.children.size(); j++) {
                    if(now.children.get(j) != null){
                        queue.add(now.children.get(j));
                    }
                }
            }
            res.add(nodes);
        }
        return res;
    }
}
