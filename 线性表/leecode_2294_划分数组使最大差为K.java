package 线性表;

public class leecode_2294_划分数组使最大差为K {
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Sort the array to find the minimum and maximum easily
        java.util.Arrays.sort(nums);

        int count = 1; // At least one partition is needed
        int start = nums[0]; // Start with the first element

        for (int i = 1; i < nums.length; i++) {
            // If the difference between current number and start exceeds k, create a new partition
            if (nums[i] - start > k) {
                count++;
                start = nums[i]; // Update start to the current number
            }
        }

        return count;
    }
}
