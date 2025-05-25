package 搜索;

public class leecode_34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {2,2};
        int a = searchRangeLeft(nums,3, 0, 1);
        System.out.println(a);
    }
    public int[] searchRange1(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
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
