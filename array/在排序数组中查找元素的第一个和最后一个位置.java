package array;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int a = searchRangeLeft(nums,3, 0, 1);
        System.out.println(a);
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        } else if (nums.length == 1) {
            if(nums[0] == target){
                return new int[]{0, 0};
            }else {
                return new int[]{-1, -1};
            }
        }else {
            int left = searchRangeLeft(nums, target, 0, nums.length-1);
            int right = searchRangeRight(nums, target, 0, nums.length-1);
            return new int[]{left, right};
        }
    }

    private static int searchRangeLeft(int[] nums, int target, int left, int right) {
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                right = mid;
            } else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid + 1;
            }
        }
        if(nums[left] == target){
            return left;
        }else {
            return -1;
        }
    }
    private static int searchRangeRight(int[] nums, int target, int left, int right) {
        while(left < right){
            int mid = (left + right)/2+1;
            if(nums[mid] == target){
                left = mid;
            } else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid + 1;
            }
        }
        if(nums[right] == target){
            return left;
        }else {
            return -1;
        }
    }
}
