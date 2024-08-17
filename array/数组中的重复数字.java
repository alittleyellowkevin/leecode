package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 数组中的重复数字 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 2};
        duplicate(nums);
    }
    public static int duplicate (int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if(set.contains(number)){
                return number;
            }else {
                set.add(number);
            }
        }
        return -1;
    }
}
