package array;

public class LCR_008_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int number = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            number += nums[i];
            if(number >= target){
                while (number - nums[j] >= target){
                    number -= nums[j];
                    j++;
                }
                result = Math.min(result, i-j+1);
            }
        }
        return result==Integer.MAX_VALUE ? 0 : result;
    }
}
