package leecode;

import java.util.LinkedList;
import java.util.Queue;

public class leecode_2221_数组三角和 {
    public int triangularSum(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        // 初始化
        for(int i=0; i<nums.length; i++){
            queue.offer(nums[i]);
        }
        while (queue.size() > 1){
            int size = queue.size();
            for(int i=0; i<size-1; i++){
                int pre = queue.poll();
                int add = queue.peek();
                queue.add((pre + add)%10);
            }
            queue.poll();
        }
        return queue.peek();
    }
}
