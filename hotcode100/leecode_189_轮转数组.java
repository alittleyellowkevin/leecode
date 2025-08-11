package hotcode100;

import java.util.Arrays;

public class leecode_189_轮转数组 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k -1);
        reverse(nums, nums.length - k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
