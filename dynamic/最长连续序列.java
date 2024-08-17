package dynamic;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 最长连续序列 {
    public static void main(String[] args) {

    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int number = nums[i];
            if(!set.contains(number-1)){
                while (set.contains(number)){
                    number++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
