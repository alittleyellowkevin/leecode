package base;

import java.util.Arrays;

public class Arrays的使用 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums);

        int[] nums1 = Arrays.copyOf(nums, 2);

        System.out.println(Arrays.toString(nums1));

        System.out.println(Arrays.binarySearch(nums, 2));

        Arrays.fill(nums, 1);
        System.out.println(Arrays.toString(nums));

        //查不到值返回 = -插入位位置-1；
        System.out.println(Arrays.binarySearch(nums, 5));

//        Arrays.sort(nums, (a, b)-> {
//            return a -b;
//        });

    }
}
