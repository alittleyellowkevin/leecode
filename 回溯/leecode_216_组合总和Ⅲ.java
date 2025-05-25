package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leecode_216_组合总和Ⅲ {
    public static void main(String[] args) {
        combinationSum3(3, 7);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        // k是数的个数，n是数的总和
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        back(numbers, 1, res, n, k);
        return res;
    }

    private static void back(ArrayList<Integer> numbers, int i, List<List<Integer>> res, int n, int k) {
        if (k == 0) {
            if (n == 0) {
                ArrayList<Integer> numberclone = new ArrayList<>();
                numberclone = (ArrayList<Integer>) numbers.clone();
                res.add(numberclone);
            }
            return;
        }
        for (int j = i; j < 10; j++) {
            numbers.add(j);
            back(numbers, j + 1, res, n - j, k - 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    // public static List<List<Integer>> combinationSum3(int k, int n) {
    // //k是数的个数，n是数的总和
    // List<List<Integer>> res = new ArrayList<>();
    // ArrayList<Integer> numbers = new ArrayList<>();
    // for (int i = 1; i < 10; i++) {
    // numbers.add(i);
    // back(numbers, i, res, n-i, k-1);
    // numbers.remove(numbers.size()-1);
    // }
    // return res;
    // }
    //
    // private static void back(ArrayList<Integer> numbers, int i,
    // List<List<Integer>> res, int n, int k) {
    // if(k == 0){
    // if(n == 0){
    // ArrayList<Integer> numberclone = new ArrayList<>();
    // numberclone = (ArrayList<Integer>) numbers.clone();
    // res.add(numberclone);
    // }
    // }else {
    // for (int j = i+1; j < 10; j++) {
    // numbers.add(j);
    // back(numbers, j, res, n-j, k-1);
    // numbers.remove(numbers.size()-1);
    // }
    // }
    // }

}
