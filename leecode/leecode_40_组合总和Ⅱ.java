package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode_40_组合总和Ⅱ {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, 0, result, list);
        return result;
    }

    private static void combine(int[] candidates, int target, int i, List<List<Integer>> result, List<Integer> list) {
        if(target == 0){
            result.add(new ArrayList<>(list));
        } else if (target>0) {
            for (int j = i; j < candidates.length; j++) {
                if(j>i && candidates[j] == candidates[j-1]){
                    continue;
                }
                list.add(candidates[j]);
                combine(candidates, target-candidates[j], j+1, result, list);
                list.remove(list.size()-1);
            }
        }
    }
}
