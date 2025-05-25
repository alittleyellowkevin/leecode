package 动态规划;

public class leecode_213_打家劫舍Ⅱ {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        rob(nums);
    }

    public static int rob(int[] nums) {

        // 1. resFirt表示不偷第一个房子，resLast表示不偷最后一个房子
        int[] resFirt = new int[nums.length - 1];
        int[] resLast = new int[nums.length - 1];

        // 2. 如果只有一个房子，则直接返回，如果只有两个房子，则返回最大值，如果只有三个房子，则返回最大值
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }

        // 3. 初始化数组，resFirt[0] = nums[0]; resFirt[1] = Math.max(nums[0], nums[1]);
        resFirt[0] = nums[0];
        resFirt[1] = Math.max(nums[0], nums[1]);

        // 初始化数组，resLast[0] = nums[1]; resLast[1] = Math.max(nums[1], nums[2]);
        resLast[0] = nums[1];
        resLast[1] = Math.max(nums[1], nums[2]);

        // 4. 遍历数组，计算resFirt和resLast，resFirt[i] = Math.max(resFirt[i-2] + nums[i] ,
        // resFirt[i-1]);
        for (int i = 2; i < nums.length - 1; i++) {
            resFirt[i] = Math.max(resFirt[i - 2] + nums[i], resFirt[i - 1]);
        }

        // resLast: resLast[i] = Math.max(resLast[i-2]+nums[i+1], resLast[i-1]);
        for (int i = 2; i < nums.length - 1; i++) {
            resLast[i] = Math.max(resLast[i - 2] + nums[i + 1], resLast[i - 1]);
        }

        return Math.max(resFirt[nums.length - 2], resLast[nums.length - 2]);
    }
}
