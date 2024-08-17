package array;

import java.util.Arrays;
import java.util.Map;

public class 最大间距 {
    public int maximumGap(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i-1]);
        }
        return max;
    }
}
