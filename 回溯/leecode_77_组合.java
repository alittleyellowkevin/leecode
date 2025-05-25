package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leecode_77_组合 {
    public static void main(String[] args) {
        combine(4, 2);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        backtrack(res, list, 1, n, k);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int i, int n, int k) {
        if (k == 0) {
            res.add((List<Integer>) list.clone());
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            backtrack(res, list, j + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
    // public static List<List<Integer>> combine(int n, int k) {
    // List<List<Integer>> res = new ArrayList<>();
    // List<Integer> linkList = new ArrayList<>();
    // for (int i = 1; i <= n; i++) {
    // linkList.add(i);
    // backtrack(res, linkList, i, k, n);
    // linkList.remove(linkList.size()-1);
    // }
    // return res;
    // }
    // public static void backtrack( List<List<Integer>> res, List<Integer>
    // linkList,int i, int k, int n){
    // if(linkList.size() == k){
    // List<Integer> clone = new ArrayList<>(linkList);
    // res.add(clone);
    // } else if (k-linkList.size() > n-i) {
    // return;
    // }else {
    // for (int j = i+1; j <= n; j++) {
    // linkList.add(j);
    // backtrack(res, linkList, j, k, n);
    // linkList.remove(linkList.size()-1);
    // }
    // }
    // }
}
