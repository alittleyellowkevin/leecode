package hotcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode_15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0){
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[start]);
                    newList.add(nums[end]);
                    result.add(newList);
                    start++;
                    end--;
                    while (end >= 0 && nums[end] == nums[end+1]) end--;
                    while (start < nums.length && nums[start] == nums[start-1]) start++;
                } else if (sum >= 0) {
                    end--;
                }else {
                    start++;
                }
            }
        }
        return result;
    }
}
