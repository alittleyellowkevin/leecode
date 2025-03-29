package backtrack;

import java.util.ArrayList;
import java.util.List;

public class leecode_39_组合总和 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        System.out.println(combinationSum(nums, 7));

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        backtrack(candidates, res, 0, target, number);
        return res;
    }

    private static void backtrack(int[] candidates, ArrayList<List<Integer>> res,int i, int result, ArrayList<Integer> number) {
        if(result == 0){
            res.add((ArrayList<Integer>) number.clone());
        }else if(result<0){
            return;
        }else {
            for (int j=i; j<candidates.length; j++) {
                number.add(candidates[j]);
                backtrack(candidates, res, j, result-candidates[j], number);
                number.remove(number.size()-1);
            }
        }
    }
}
