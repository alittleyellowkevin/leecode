package 搜索;

public class leecode_153_寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        minNumberInRotateArray(nums);
    }
    public static int minNumberInRotateArray(int [] nums) {
        // 特殊情况判断
        if (nums.length== 0) {
            return 0;
        }
        // 左右指针i j
        int i = 0, j = nums.length - 1;
        // 循环
        while (i < j) {
            // 找到数组的中点 m
            int m = (i + j) / 2;
            // m在左排序数组中，旋转点在 [m+1, j] 中
            if (nums[m] > nums[j]) i = m + 1;
                // m 在右排序数组中，旋转点在 [i, m]中
            else if (nums[m] < nums[j]) j = m;
                // 缩小范围继续判断
            else j--;
        }
        // 返回旋转点
        return nums[i];
    }


}
