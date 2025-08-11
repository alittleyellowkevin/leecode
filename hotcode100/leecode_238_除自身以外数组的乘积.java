package hotcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode_238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int countZero = 0;
        int zeroPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                countZero++;
                zeroPosition = i;
                continue;
            }
            sum *= nums[i];
        }
        if(countZero > 1){
            int[] results = new int[nums.length];
            Arrays.fill(results, 0);
            return results;
        } else if (countZero == 1) {
            int[] results = new int[nums.length];
            Arrays.fill(results, 0);
            results[zeroPosition] = sum;
            return results;
        } else {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                result.add(sum / nums[i]);
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
