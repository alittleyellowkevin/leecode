package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_46_全排列 {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        create(nums, result, list);
        return result;
    }

    private static void create(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]<=10 && nums[i] >= -10){
                    list.add(nums[i]);
                    int temp = nums[i];
                    nums[i] = -11;
                    create(nums, result, list);
                    nums[i] = temp;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
