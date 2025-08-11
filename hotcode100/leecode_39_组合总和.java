package hotcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode_39_组合总和 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backsort(candidates, 0,0, target, list);
        return result;
    }

    private void backsort(int[] candidates, int start, int sum, int target, List<Integer> list) {
        if(sum > target){
            return;
        } else if (sum == target) {
            result.add(list.stream().toList());
        }else {
            for(int i=start; i<candidates.length; i++){
                list.add(candidates[i]);
                sum += candidates[i];
                backsort(candidates, i, sum, target, list);
                sum -= candidates[i];
                list.remove(list.size()-1);
            }
        }
    }
}
