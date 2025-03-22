package leecode;

public class leecode_80_删除有序数组中的重复项Ⅱ {
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        int start = 0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i] == nums[start]){
                count++;
                if(count<=2){
                    start++;
                    swap(nums, start, i);

                }
            }else {
                count = 1;
                start++;
                swap(nums, start, i);
            }
        }
        return start+1;
    }
    public static void swap(int[] nums, int l, int r){
        int mid = nums[l];
        nums[l] = nums[r];
        nums[r] = mid;
    }
}
