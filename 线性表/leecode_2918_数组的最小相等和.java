package 线性表;

import java.util.Arrays;

public class leecode_2918_数组的最小相等和 {
    public static void main(String[] args) {

    }

    public long minSum(int[] nums1, int[] nums2) {
        // 处理 nums1
        long nums1Min = 0;
        long nums1Max = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1Min++;
                nums1Max = Integer.MAX_VALUE;
            } else {
                nums1Min += nums1[i];
            }
        }
        nums1Max = nums1Max != Integer.MAX_VALUE ? nums1Min : nums1Max;
        // 处理 nums2
        long nums2Min = 0;
        long nums2Max = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                nums2Min++;
                nums2Max = Integer.MAX_VALUE;
            } else {
                nums2Min += nums1[i];
            }
        }
        nums2Max = nums2Max != Integer.MAX_VALUE ? nums2Min : nums2Max;
        if (nums2Max < nums1Min || nums2Min > nums1Max) {
            return -1;
        } else {
            return Math.max(nums1Min, nums2Min);
        }

    }

}
