package 线性表;

import java.util.ArrayList;
import java.util.List;

public class leecode_2200_找出数组中的所有K近邻下标 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == key){
                int resultSize = result.size();
                int start=i-k;
                int end = i+k;
                if(resultSize != 0){
                    start = Math.max(start, result.get(resultSize-1)+1);
                }
                start = Math.max(0, start);
                end = Math.min(end, nums.length-1);
                int j=start;
                while(j<=end){
                    result.add(j);
                    j++;
                }
            }
        }
        return result;
    }
}
