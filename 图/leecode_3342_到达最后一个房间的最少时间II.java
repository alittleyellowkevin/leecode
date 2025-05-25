package 图;

import java.lang.Thread.State;
import java.util.PriorityQueue;

public class leecode_3342_到达最后一个房间的最少时间II {
    public int minTimeToReach(int[][] moveTime) {
        // 定义变量
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        PriorityQueue<State> priorityQueue = new PriorityQueue<>();
        int cost = 0; // 每次移动需要的花费

        // 初始化
        dist[0][0] = 0;
        priorityQueue.add(new State(0, 0, 0));

        // 循环执行
        while (!priorityQueue.isEmpty()) {
            cost++;
            State now = priorityQueue.poll();
            int nx = now.x;
            int ny = now.y;
            visited[nx][ny] = true; // 将当前节点设置为已访问

            // 查看其他节点
            for (int[] direction : directions) {
                int sx = nx + direction[0];
                int sy = ny + direction[1];
                // 如果移动方向节点已经访问过或是不在范围内，则更改为其他节点
                if (sx < 0 || sx > visited.length - 1 || sy < 0 || sy > visited[0].length || visited[sx][sy]) {
                    continue;
                }
                // 否则计算当前节点移动到下一节点需要的 length ,如果小于原有dist则更新
                else {
                    int length = Math.max(moveTime[sx][sy], dist[nx][ny]) + cost;
                    if (length < dist[sx][sy]) {
                        dist[sx][sy] = length;
                    }
                }
            }
        }
        return dist[m - 1][n - 1];

    }

    static class State implements Comparable<State> {
        int x;
        int y;
        int length;

        public State(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }

        @Override
        public int compareTo(State other) {
            return this.length - other.length;
        }
    }

}
