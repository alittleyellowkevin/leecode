package hotcode100;

public class leecode_53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        int minPre = 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum - minPre);
            minPre = Math.min(sum, minPre);
        }
        return result;
    }
}
