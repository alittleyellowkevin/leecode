package tree;

import sort.插入排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉搜索树中的众数 {
        public static class TreeNode {
                                                int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {

    }
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        pre(root, map);
        List<Integer> res = new ArrayList<>();
        int tag = 100001;
        int[] maxlength = {-1};
        map.forEach((k,v) ->{
            if(v> maxlength[0]){
                res.clear();
                maxlength[0] = v;
                res.add(k);
            } else if (v == maxlength[0]) {
                res.add(k);
            }
        });
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void pre(TreeNode root, Map<Integer, Integer> res) {
            if(res.containsKey(root.val)){
                res.replace(root.val, res.get(root.val) + 1);
            }else {
                res.put(root.val, 1);
            }
            if(root.left!=null){
                pre(root.left, res);
            }
            if(root.right!=null){
                pre(root.right, res);
            }
    }


}