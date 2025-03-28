package search;

public class leecode_81_搜索旋转排序数组Ⅱ {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 0;
        search2(nums, target);
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean search2(int[] nums, int target) {

        int n = nums.length;
        if (n == 1) {
            return nums[0] == target;
        }

        int l = 0, r = n - 1;
        while (l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] > nums[r]){
                if(target >= nums[l] && target<= nums[mid]){
                    r = mid -1;
                }else {
                    l = mid+1;
                }
            } else if (nums[mid] < nums[r]) {
                if(target <= nums[r] && target>=nums[mid]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }else {
                if(nums[mid] != target){
                    r--;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
