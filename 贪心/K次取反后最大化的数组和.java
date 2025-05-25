package 贪心;

import java.util.Arrays;

public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(k == 0){
                break;
            }else{
                if(nums[i] >= 0){
                    if(k % 2 == 0){
                        k=0;
                        break;
                    }else {
                        if(i != 0){
                            if(nums[i] > nums[i-1]){
                                nums[i-1] = -nums[i-1];
                                k=0;
                                break;
                            }else{
                                k=0;
                                nums[i] = - nums[i];
                                break;
                            }
                        }else{
                            k = 0;
                            nums[i] = -nums[i];
                            break;
                        }
                    }
                }else {
                    nums[i] = -nums[i];
                    k--;
                }
            }
        }
        if(k%2 != 0){
            nums[nums.length-1] = -nums[nums.length-1];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res+nums[i];
        }
        return res;
    }
}
