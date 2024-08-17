package leecode;

import java.util.Arrays;

public class leecode_31_下一个排列 {
    public static void main(String[] args) {
        nextPermutation(new int[]{1});
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length-2;
        for (; i >= 0; i--) {
            if(nums[i] < nums[i+1]){
                break;
            }
        }
        if(i==-1){
            reverse(nums, -1);
            return;
        }
        int j = 0;
        for (j = nums.length-1;  j > i ; j--) {
            if(nums[j] > nums[i]){
                swap(nums, i, j);
                reverse(nums, i);
                break;
            }
        }

    }

    private static void reverse(int[] nums, int i) {
        int l = i+1;
        int r = nums.length-1;
        while (l<r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
