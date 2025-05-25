package 贪心;

import java.util.Map;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] + nums[i] > nums[i]){
                nums[i] = nums[i-1] + nums[i];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
