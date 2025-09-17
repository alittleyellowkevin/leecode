package leecode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class leecode_1792_最大平均通过率 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
       Queue<int[]> priorityQueue = new PriorityQueue<>((a, b)->{
           if(a[1] == b[1]){
               return a[0] - b[0];
           }
           return  a[1] - b[1];
       });

       for(int i=0; i<classes.length; i++){
           priorityQueue.add(new int[]{classes[i][0], classes[i][1]});
       }

       while (extraStudents>0){
           priorityQueue.
           extraStudents--;
       }
    }

}
