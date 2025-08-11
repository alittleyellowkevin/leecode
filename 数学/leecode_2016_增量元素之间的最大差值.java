package 数学;

public class leecode_2016_增量元素之间的最大差值 {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int result = Integer.MIN_VALUE;
        for(int i=1; i< nums.length; i++){
            if(nums[i] - min > result){
                result = nums[i] - min;
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return result <= 0 ? -1 : result;
    }
}
