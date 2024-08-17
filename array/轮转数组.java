package array;

public class 轮转数组 {
    public void rotate(int[] nums, int k) {
        swap(nums, 0, nums.length-k-1);
        swap(nums, nums.length-k, nums.length-1);
        swap(nums, 0, nums.length-1);
    }

    private void swap(int[] nums, int l, int r) {
        while (l<r){
            int mid = nums[l];
            nums[l] = nums[r];
            nums[r] = mid;
            r--;
            l++;
        }
    }

}
