package 回溯;

import java.util.*;

public class leecode_40_组合总和Ⅱ {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 2, 1, 2 };
        System.out.println(combinationSum2(nums, 7));

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        backtrack(candidates, res, 0, target, number);
        return res;
    }

    private static void backtrack(int[] candidates, ArrayList<List<Integer>> res, int i, int result,
            ArrayList<Integer> number) {
        if (result == 0) {
            res.add((ArrayList<Integer>) number.clone());
        } else if (result < 0) {
            return;
        } else {
            Set<Integer> mySet = new HashSet<>();
            for (int j = i; j < candidates.length; j++) {
                if (!mySet.contains(candidates[j])) {
                    mySet.add(candidates[j]);
                    number.add(candidates[j]);
                    backtrack(candidates, res, j + 1, result - candidates[j], number);
                    number.remove(number.size() - 1);
                }
            }
        }
    }
}
// HashMap<Integer, Boolean> map = new HashMap<>();
// for (int i = 0; i < candidates.length; i++) {
// map.put(i, false);
// }
// Arrays.sort(candidates);
// ArrayList<List<Integer>> res = new ArrayList<>();
// ArrayList<Integer> number = new ArrayList<>();
// for (int i = candidates.length-1; i >=0; i--) {
// if(i < candidates.length-1 && candidates[i] == candidates[i+1]){
// continue;
// }
// if(target - candidates[i] >= 0) {
// number.add(candidates[i]);
// backtrack(map, candidates, res, i, target - candidates[i], number);
// number.remove(number.size()-1);
// }
// }
// return res;
// }
//
// private static void backtrack(HashMap<Integer, Boolean> map, int[]
// candidates, ArrayList<List<Integer>> res,int j, int result,
// ArrayList<Integer> number) {
// if(result == 0){
// ArrayList<Integer> numberclone = new ArrayList<>();
// numberclone = (ArrayList<Integer>) number.clone();
// if(j != candidates.length-1 && map.get(j+1) == false && candidates[j] ==
// candidates[j+1]){
// return;
// }
// res.add(numberclone);
//
// }else if(result<0){
// return;
// }else {
// for (int i=j-1; i >=0; i--) {
// if(result - candidates[i] >= 0){
// number.add(candidates[i]);
// map.replace(i, false, true);
// backtrack(map, candidates, res, i,result-candidates[i], number);
// number.remove(number.size()-1);
// map.replace(i, true, false);
// }
// }
// }
// }
