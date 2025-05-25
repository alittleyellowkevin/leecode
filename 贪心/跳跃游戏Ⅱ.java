package 贪心;

public class 跳跃游戏Ⅱ {
    public static int jump(int[] nums) {
        int res=0;
        int i = 0;
        if(nums.length == 1){
            return 0;
        }
        while(i!=nums.length-1){
            i = jum(nums, i);
            res++;
        }
        return res;
    }

    private static int jum(int[] nums, int i) {
        int number = nums[i];
        if(i+nums[i] < nums.length-1){
            int max = nums[i+1] + 1;
            int maxTag = i+1;
            for (int j = i+2; j <= i+nums[i]; j++) {
                if(j<nums.length && nums[j] + (j-i) >= max){
                    max = nums[j] + (j-i);
                    maxTag = j;
                }
            }
            return maxTag;
        }else {
            return nums.length-1;
        }

    }
}
