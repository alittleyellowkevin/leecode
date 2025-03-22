package leecode;

import java.util.Arrays;

public class leecode_75_颜色分类 {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                swap(nums, red, i);
                if(red != white){
                    swap(nums, white, i);
                }
                red++;
                white++;
            } else if (nums[i] == 1) {
                swap(nums, white, i);
                white++;
            }
        }
    }
    public void swap(int[] nums, int l, int r){
        int mid = nums[l];
        nums[l] = nums[r];
        nums[r] = mid;
    }
}
