package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode_77_组合 {
    public static void main(String[] args) {
        combine(4, 2);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> reuslt = new ArrayList<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        backsort(buffer, reuslt, 1, k, n);
        return reuslt;
    }
    private static void backsort(ArrayList<Integer> buffer, List<List<Integer>> reuslt, int i, int k, int n) {
        if(buffer.size() == k){
            reuslt.add((ArrayList<Integer>)buffer.clone());
        }else {
            for (int j = i; j <= n; j++) {
                buffer.add(j);
                backsort(buffer, reuslt, j+1, k, n);
                buffer.remove(buffer.size()-1);
            }
        }
    }
}
