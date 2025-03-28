package leecode;

import entity.Node;

import java.util.HashMap;

public class leecode_133_克隆图 {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> set = new HashMap<>();
        return createNode(node, set);
    }

    private Node createNode(Node node, HashMap<Integer, Node> map) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }else {
            Node nodeNew = new Node(node.val);
            map.put(node.val, nodeNew);
            for (Node n : node.neighbors) {
                nodeNew.neighbors.add(createNode(n, map));
            }
            return nodeNew;
        }
    }
}
