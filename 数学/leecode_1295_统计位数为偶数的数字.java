package 数学;

public class leecode_1295_统计位数为偶数的数字 {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = 0;
            while (num != 0) {
                num /= 10;
                count++;
            }
            if (count % 2 == 0)
                res++;
        }
        return res;
    }
}
