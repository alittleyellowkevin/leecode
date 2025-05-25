package 堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class leecode_373_查找最小的K对数字 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // 小顶堆，按照数对的和排序
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        // 初始化：将nums1的每个数和nums2的第一个数组成的下标对加入队列
        for (int i = 0; i < nums1.length && i < k; i++) {
            // 数组存储nums1和nums2的下标
            pq.offer(new int[] { i, 0 });
        }

        // 循环k次或队列为空时结束
        while (k-- > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[0];
            int j = current[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // 如果还有下一个数，将下一个数对加入队列
            if (j + 1 < nums2.length) {
                pq.offer(new int[] { i, j + 1 });
            }
        }

        return result;
    }
}
