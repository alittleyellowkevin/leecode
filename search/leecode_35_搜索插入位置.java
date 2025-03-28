package search;

public class leecode_35_搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println(searchInsert(nums, 6));
    }

    public static int searchInsert(int[] nums, int target) {
        int result = twoSearch(nums, 0, nums.length-1, target);
        return result;
    }
    public static int twoSearch(int[] nums, int left, int right, int target){
        int result;
        if (left<right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                result = twoSearch(nums, left, mid, target);
            }
            else if (nums[mid] < target) {
                result = twoSearch(nums, mid + 1, right, target);
            } else {
                return mid;
            }
        }else {
            return left;
        }
        return result;
    }
}
