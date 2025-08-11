package hotcode100;

import java.util.*;

public class leecode_207_课程表 {
    List<List<Integer>> edges;
    int[] countPre;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [A][B] 学A 之前要 学 B， 所以当某行的所有列都为-1时，则表示该门课可以进行学习了

        // 初始化
        edges = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            edges.add(new ArrayList<>());
        }
        countPre = new int[numCourses];
        Arrays.fill(countPre, 0);
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisity = prerequisites[i];
            // 标志这个点到其他点的路径
            edges.get(prerequisity[1]).add(prerequisity[0]);
            // 标志其他点有多少到它的数量
            countPre[prerequisity[0]]++;
        }

        // 开始遍历
        bfs(countPre);


        //返回
        for (int i = 0; i < countPre.length; i++) {
            if(countPre[i] > 0){
                return false;
            }
        }
        return true;
    }

    private void bfs(int[] countPre) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        for(int i=0; i<countPre.length; i++){
            if(countPre[i] == 0){
                nodeQueue.add(i);
            }
        }
        while (!nodeQueue.isEmpty()){
            int n = nodeQueue.size();
            for (int i = 0; i < n; i++) {
                int node = nodeQueue.poll();
                for (int j = 0; j < edges.get(node).size(); j++) {
                    int point = edges.get(node).get(j);
                    countPre[point]--;
                    if(countPre[point] == 0){
                        nodeQueue.add(point);
                    }
                }
            }
        }
    }

}
