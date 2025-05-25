package 线性表;

import java.util.ArrayList;
import java.util.List;

public class Hard_leecode_2444_统计定界子数组的数目 {
    public long countSubarrays(int[] nums, long minK, long maxK) {
        long res = 0;
        long minLast = -1;
        long maxLast = -1;
        long border = -1;
        for (long i = 0; i < nums.length; i++) {
            long cur = nums[(int) i];
            if (cur < minK || cur > maxK) {
                minLast = -1;
                maxLast = -1;
                border = i;
            }

            if (cur == minK) {
                minLast = i;
            }

            if (cur == maxK) {
                maxLast = i;
            }

            if (minLast != -1 && maxLast != -1) {
                res += Math.min(maxLast, minLast) - border;
            }
        }
        return res;
    }
}
