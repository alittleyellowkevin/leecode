package backtrack;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    public static void main(String[] args) {
        combine(4, 2);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(res, list,1, n, k);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int i, int n, int k) {
        if(k == 0){
            res.add((List<Integer>) list.clone());
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            backtrack(res, list, j+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
//    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//            backtrack(res, list, i, k, n);
//            list.remove(list.size()-1);
//        }
//        return res;
//    }
//    public static void backtrack( List<List<Integer>> res, List<Integer> list,int i, int k, int n){
//        if(list.size() == k){
//            List<Integer> clone = new ArrayList<>(list);
//            res.add(clone);
//        } else if (k-list.size() > n-i) {
//            return;
//        }else {
//            for (int j = i+1; j <= n; j++) {
//                list.add(j);
//                backtrack(res, list, j, k, n);
//                list.remove(list.size()-1);
//            }
//        }
//    }
}
