package 线性表;

import java.util.ArrayList;
import java.util.List;

public class leecode_442_数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int number = Math.abs(nums[i]);
            if (nums[number] < 0) {
                res.add(number);
            } else {
                nums[number] = -nums[number];
            }
        }
        return res;
    }
}
