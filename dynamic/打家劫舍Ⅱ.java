package dynamic;

public class 打家劫舍Ⅱ {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        rob(nums);
    }
    public static int rob(int[] nums) {
        int[] resFirt = new int[nums.length-1];
        int[] resLast = new int[nums.length-1];
        if(nums.length == 1) return nums[0];
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }else if(nums.length == 3){
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        //初始化数组
        resFirt[0] = nums[0];
        resFirt[1] = Math.max(nums[0], nums[1]);

        resLast[0] = nums[1];
        resLast[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length-1; i++) {
            resFirt[i] = Math.max(resFirt[i-2] + nums[i], resFirt[i-1]);
        }
        for (int i = 2; i < nums.length-1; i++) {
            resLast[i] = Math.max(resLast[i-2]+nums[i+1], resLast[i-1]);
        }

        return Math.max(resFirt[nums.length-2], resLast[nums.length-2]);
    }
}
