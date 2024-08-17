package leecode;

public class leecode_33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }else {
                if (nums[mid] > nums[r]){
                    if(target>=nums[l] && target<nums[mid]){
                        r = mid-1;
                    }else {
                        l = mid+1;
                    }
                }else {
                    if(target>nums[mid] && target<=nums[r]){
                        l = mid+1;
                    }else {
                        r = mid-1;
                    }
                }
            }
        }
        return -1;
    }
}
