package 堆;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class leecode_215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        // 使用优先队列
        Queue<Integer> priorityQueue = new PriorityQueue<>(k, Collections.reverseOrder());

        // 循环遍历 nums
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }
}
