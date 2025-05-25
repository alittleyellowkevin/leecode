package 堆;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class leecode_502_IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // 使用两个优先队列来优化时间复杂度
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 将资本和利润对存入最小堆
        for (int i = 0; i < profits.length; i++) {
            capitalMinHeap.offer(new int[] { capital[i], profits[i] });
        }

        // 进行k轮项目选择
        for (int i = 0; i < k; i++) {
            // 将所有可以启动的项目的利润加入最大堆
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= w) {
                profitMaxHeap.offer(capitalMinHeap.poll()[1]);
            }

            // 如果没有可以启动的项目，结束循环
            if (profitMaxHeap.isEmpty()) {
                break;
            }

            // 选择利润最大的项目
            w += profitMaxHeap.poll();
        }

        return w;
    }
}
