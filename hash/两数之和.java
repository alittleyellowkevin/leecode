package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
    //方法一：两重循环

    //方法二：使用Hashmap
    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }else {
                map.put(nums[i], i);
            }
        }
        int num1 = 1;
        Integer a = num1;

        return res;



    }


}
