package leecode;

public class leecode_53_最大子数组和 {
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(nums[i], result);
        }
        if(result < 0){
            return result;
        }
        nums[0] = Math.max(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(0, nums[i] + nums[i-1]);
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}
