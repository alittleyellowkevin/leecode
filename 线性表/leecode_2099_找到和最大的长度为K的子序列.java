package 线性表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class leecode_2099_找到和最大的长度为K的子序列 {
    public int[] maxSubsequence(int[] nums, int k) {
        return IntStream.range(0, nums.length).boxed()
                .sorted(Comparator.<Integer>comparingInt(i -> nums[i]).reversed())
                .limit(k)
                .sorted()
                .mapToInt(i -> nums[i])
                .toArray();
    }
}
