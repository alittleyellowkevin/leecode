package leecode;

public class leecode_34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
    public static int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l < r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                r = mid;
            } else if (nums[mid]> target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        int l1 = 0;
        int r1 = nums.length-1;
        while (l1 < r1){
            int mid = (l1+r1)/2+1;
            if(nums[mid] == target){
                l1 = mid;
            } else if (nums[mid] > target) {
                r1 = mid-1;
            }else {
                l1 = mid+1;
            }
        }
        return nums[l] == target? new int[]{l, l1}:new int[]{-1, -1};
    }
}
