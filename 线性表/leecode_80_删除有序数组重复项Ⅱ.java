package 线性表;

public class leecode_80_删除有序数组重复项Ⅱ {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 2, 3, 3 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int number = 0;
        int start = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                number++;
                if (number >= 2) {
                    continue;
                } else {
                    nums[start] = nums[i];
                    start++;
                }
            } else {
                nums[start] = nums[i];
                start++;
                number = 0;
            }
        }
        return start;
    }
}
