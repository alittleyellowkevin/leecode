package leecode;

public class leecode_26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int j=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j;
    }
}
