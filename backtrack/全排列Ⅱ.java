package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 全排列Ⅱ {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<Integer> myset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == false && !myset.contains(nums[i])) {
                myset.add(nums[i]);
                flag[i] = true;
                number.add(nums[i]);
                xunhuan(res, number, nums, flag);
                number.remove(number.size() - 1);
                flag[i] = false;
            }
        }
    }
}
