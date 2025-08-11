package hotcode100;

import java.util.HashMap;

public class leecode_560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int result = 0;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        numCount.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if(numCount.containsKey(target)){
                result += numCount.get(target);
            }
            numCount.put(sum, numCount.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
