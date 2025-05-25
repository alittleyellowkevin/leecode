package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leecode_46_全排列 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 6 };
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        xunhuan(res, number, nums, flag);
        return res;
    }

    private static void xunhuan(List<List<Integer>> res, ArrayList<Integer> number, int[] nums, boolean[] flag) {
        if (number.size() == nums.length) {
            res.add((List<Integer>) number.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                number.add(nums[i]);
                xunhuan(res, number, nums, flag);
                number.remove(number.size() - 1);
                flag[i] = false;
            }
        }
    }
}
