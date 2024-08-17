package leecode;

import java.util.Arrays;

public class leecode_16_最接近的三数之和 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res=0;
        for (int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                if(j != i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(k != nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                int number = nums[i] + nums[j] + nums[k];

                if(number - target>0){
                    k--;
                    if(number - target < min){
                        min = number - target;
                        res = number;
                    }
                } else if (number - target < 0) {
                    j++;
                    if(target - number < min){
                        min = target - number;
                        res = number;
                    }
                }else {
                    return target;
                }
            }
        }
        return res;
    }
}
