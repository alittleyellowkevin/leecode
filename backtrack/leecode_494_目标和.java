package backtrack;

public class leecode_494_目标和 {
    public static void main(String[] args) {
        int[] nums = { 1 };
        findTargetSumWays(nums, 1);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1];
        backtrack(nums, target, 0, 0, res);
        return res[0];
    }

    public static void backtrack(int[] nums, int target, int index, int sum, int[] res) {
        if (index == nums.length) {
            if (sum == target) {
                res[0]++;
            }
            return;
        }
        backtrack(nums, target, index + 1, sum + nums[index], res);
        backtrack(nums, target, index + 1, sum - nums[index], res);
    }

}
