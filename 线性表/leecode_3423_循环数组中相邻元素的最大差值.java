package 线性表;

public class leecode_3423_循环数组中相邻元素的最大差值 {
    public int maxAdjacentDistance(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        for(int i=1; i<=nums.length; i++){
            int left = i-1;
            int right = i % nums.length;
            int gap = nums[right] - nums[left];
            gap = gap>0?gap:-gap;
            if(gap > maxValue){
                maxValue = gap;
            }
        }
        return maxValue;
    }
}
