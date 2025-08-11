package hotcode100;

import java.util.*;

public class leecode_239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });

        //初始化
        for (int i = 0; i <k ; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        result.add(priorityQueue.peek()[0]);

        for(int i=k; i<nums.length; i++){
            priorityQueue.offer(new int[]{nums[i], i});
            while (priorityQueue.peek()[1] <= i-k){
                priorityQueue.poll();
            }
            result.add(priorityQueue.peek()[0]);
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
