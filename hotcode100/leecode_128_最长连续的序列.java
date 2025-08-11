package hotcode100;

import java.util.HashSet;

public class leecode_128_最长连续的序列 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int count = Integer.MIN_VALUE;
        for(int num : numSet){
            if(numSet.contains(num-1)){
                continue;
            }
            int len=1;
            while (numSet.contains(num+1)){
                num++;
                len++;
            }
            count = Math.max(count, len);
        }
        return count;
    }
}
