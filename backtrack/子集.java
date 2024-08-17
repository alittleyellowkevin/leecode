package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            back(res,list, nums, i);
            list.remove(list.size()-1);
        }
        return res;
    }

    private static void back(List<List<Integer>> res,List<Integer> list,  int[] nums, int i) {
        if(i == nums.length-1){
            return;
        }else {
            for (int j = i + 1; j < nums.length; j++) {
                list.add(nums[j]);
                res.add(new ArrayList<>(list));
                back(res, list, nums, j);
                list.remove(list.size() - 1);
                while (j+1 < nums.length && nums[j] == nums[j+1]){
                    j++;
                }
            }
        }
    }
}
