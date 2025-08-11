package 线性表;

import java.util.Arrays;

public class leecode_2616_最小化数对的最大差值 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int[] gaps = new int[nums.length-1];
        for(int i=0; i<nums.length-1; i++){
            int gap = nums[i+1] - nums[i];
            gap = gap > 0? gap:-gap;
            gaps[i] = gap;
        }
        Arrays.sort(gaps);
        return gaps[p];
    }
}
