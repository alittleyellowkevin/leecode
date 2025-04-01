package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leecode_2560_打家劫舍Ⅳ {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 9 };
        minCapability(nums, 2);
    }

    public static int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            boolean visited = false;
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }
}
