package leecode;

import java.util.HashMap;
import java.util.Map;

public class leecode_1_两数之和 {
    public static void main(String[] args) {

    }
//    方法一 哈希表
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(target - nums[i])){
               map.put(nums[i], i);
            }else {
                return new int[]{map.get(target-nums[i]), i};
            }
        }
        return new int[]{0, 0};
    }
//      方法二 暴力枚举
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
