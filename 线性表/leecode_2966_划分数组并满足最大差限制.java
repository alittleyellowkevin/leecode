package 线性表;

import java.util.ArrayList;
import java.util.Arrays;

public class leecode_2966_划分数组并满足最大差限制 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0; i<nums.length; i+=3) {
            if(nums[i+2] - nums[i] <= k) {
                int[] subArray = new int[3];
                subArray[0] = nums[i];
                subArray[1] = nums[i+1];
                subArray[2] = nums[i+2];
                result.add(subArray);
            } else {
                return new int[][]{};
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
