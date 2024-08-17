package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_39_组合总和 {
    public static void main(String[] args) {
        combinationSum(new int[]{2, 2, 3, 7}, 7);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combine(candidates, target, 0, result, list);
        return result;
    }

    private static void combine(int[] candidates, int target, int i, List<List<Integer>> result, List<Integer> list) {
        if(target == 0){
            result.add(new ArrayList<>(list));
        } else if (target>0) {
            for (int j = i; j < candidates.length; j++) {
                list.add(candidates[j]);
                combine(candidates, target-candidates[j], j, result, list);
                list.remove(list.size()-1);
            }
        }
    }
}
