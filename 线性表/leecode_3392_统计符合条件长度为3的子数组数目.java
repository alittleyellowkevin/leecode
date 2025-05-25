package 线性表;

public class leecode_3392_统计符合条件长度为3的子数组数目 {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            double pre = nums[i];
            double mid = nums[i + 1];
            double post = nums[i + 2];
            if (pre + post == (mid) / 2) {
                count++;
            }
        }
        return count;
    }
}
