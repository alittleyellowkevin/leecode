package array;

import java.util.HashMap;
import java.util.Map;

public class leecode_169_多数元素 {
    public int majorityElement(int[] nums) {
        int max=-1;
        int maxcount=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i])+1);
                if(maxcount<map.get(nums[i])){
                    maxcount = map.get(nums[i]);
                    max = nums[i];
                }
            }else {
                map.put(nums[i], 1);
                if(maxcount<map.get(nums[i])){
                    maxcount = map.get(nums[i]);
                    max = nums[i];
                }
            }
        }
        return max;
    }
}
