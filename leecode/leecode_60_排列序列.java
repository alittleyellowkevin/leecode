package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_60_排列序列 {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        StringBuffer sb = new StringBuffer();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return null;
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
