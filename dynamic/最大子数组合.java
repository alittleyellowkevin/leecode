package dynamic;

public class 最大子数组合 {
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for(int num : nums){
            pre = Math.max(pre+num, num); //pre表示以i为结尾的最大子序列和
            max = Math.max(max, pre);
        }
        return max;
    }
}
