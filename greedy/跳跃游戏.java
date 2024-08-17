package greedy;

public class 跳跃游戏 {
    public static void main(String[] args) {
        int[] numbers = {1,1,2,2,0,1,1};
        System.out.println(canJump(numbers));
    }
    public static boolean canJump(int[] nums) {
        int i = Jump(nums, 0);
        if(i == nums.length-1){
            return true;
        }else {
            return false;
        }
    }

    private static int Jump(int[] nums, int i) {
        if(i+nums[i] >= nums.length-1)
        {
            return nums.length-1;
        }else {
            if(nums[i] == 0){
                return i;
            }else {
                int max = 0;
                int maxTag = i;
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if(nums[j] + (j-i) - nums[i] > max){
                        max = nums[j] + (j-i) - nums[i];
                        maxTag = j;
                    }
                }
                if(max == 0){
                    return i;
                }else {
                    return Jump(nums, maxTag);
                }
            }
    }
    }
}
