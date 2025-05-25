package 线性表;

public class leecode_2302_统计得分小于K的子数组数目 {
    public static void main(String[] args) {
        leecode_2302_统计得分小于K的子数组数目 solution = new leecode_2302_统计得分小于K的子数组数目();
        int[] nums = { 2, 1, 4, 3, 5 };
        int k = 10;
        System.out.println(solution.countSubarrays(nums, k));
    }

    public long countSubarrays(int[] nums, long k) {
        long sum = 0; // 记录当前分数
        long left = 0; // 左边界
        long right = 0; // 右边界
        long result = 0; // 结果

        for (; right < nums.length; right++) {
            sum += nums[(int) right];
            long score = sum * (right - left + 1);
            while (left <= right && score >= k) {
                sum -= nums[(int) left];
                left++;
                score = sum * (right - left + 1);
            }
            result += (right - left + 1);

        }
        return result;
    }
}
