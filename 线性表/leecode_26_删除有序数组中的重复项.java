package 线性表;

public class leecode_26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 2, 3, 3, 3, 4, 5 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int q = 0;
        int p = 1;
        while (p != nums.length) {
            if (nums[q] == nums[p]) {
                p++;
            } else {
                q = q + 1;
                nums[q] = nums[p];
                p = p + 1;
            }
        }
        return q + 1;
    }
}
