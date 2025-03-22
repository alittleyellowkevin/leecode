package number;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class Pow_leecode_50 {
    public static void main(String[] args) {
        subarraySum(new int[]{1, -1, 0}, 0);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i<nums.length ; i++){
            int sum = 0;
            for (int j = i; j < nums.length ; j++) {
                sum += nums[i];
            }
            if(sum == k){
                count++;
            }
        }
        return count;
    }
}
