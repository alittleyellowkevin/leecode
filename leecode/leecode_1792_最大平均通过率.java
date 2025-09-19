package leecode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class leecode_1792_最大平均通过率 {
    public static void main(String[] args) {
        int[][] testCase1 = {
                {1, 2},   // 第一组：a=1, b=2 → 比率 1/2 = 0.5
                {3, 5},   // 第二组：a=3, b=5 → 比率 3/5 = 0.6
                {2, 2}    // 第三组：a=2, b=2 → 比率 2/2 = 1.0
        };

        int[][] testCase = {{2,4}, {3,9}, {4,5}, {2,10}};

        maxAverageRatio(testCase, 4);
    }
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b)->{
            double ArateAdd = (double)(b[0]+1)/(double)(b[1]+1) - (double)(b[0])/(double)(b[1]);
            double BrateAdd = (double)(a[0]+1)/(double)(a[1]+1) - (double)(a[0])/(double)(a[1]);
            return BrateAdd - ArateAdd > 0? -1:1;
        });

        for (int[] aClass : classes) {
            priorityQueue.add(new int[]{aClass[0], aClass[1]});
        }

        double deno = classes.length;
        double nume = 0;
        while (extraStudents>0 && !priorityQueue.isEmpty()){
            int[] top = priorityQueue.poll();
            if(top[1] == top[0]) {
                nume += 1;
            }else {
                extraStudents--;
                priorityQueue.add(new int[]{top[0] + 1, top[1] + 1});
            }
        }
        while (!priorityQueue.isEmpty()){
            int[] top = priorityQueue.poll();
            nume += (double)top[0]/(double) top[1];
        }

        return nume/deno;
    }

}
