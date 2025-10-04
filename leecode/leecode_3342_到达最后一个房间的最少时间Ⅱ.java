package leecode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leecode_3342_到达最后一个房间的最少时间Ⅱ {
    public static void main(String[] args) {
        int[][] nums = {{38,87,68,34,32,8}, {3,29,39,73,86,10}};
        minTimeToReach(nums);
    }
    private static final int INF = 0x3f3f3f3f;
    static class State implements Comparable<State> {
        int x, y, dis;
        State(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        @Override
        public int compareTo(State other) {
            return Integer.compare(this.dis, other.dis);
        }
    }

    public static int minTimeToReach(int[][] moveTime) {
        // 获取网格的行数n和列数m
        int n = moveTime.length, m = moveTime[0].length;

        // d[i][j] 表示从起点(0,0)到达(i,j)位置的最小时间/代价
        int[][] d = new int[n][m];

        // v[i][j] 标记位置(i,j)是否已经被访问过（已确定最短路径）
        boolean[][] v = new boolean[n][m];

        // 初始化距离数组，将所有位置初始化为无穷大（表示初始时不可达）
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
        }

        // 定义四个移动方向：下、上、右、左
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 起点(0,0)的初始代价为0
        d[0][0] = 0;

        // 使用优先队列（最小堆）实现Dijkstra算法，按代价从小到大排序
        PriorityQueue<State> q = new PriorityQueue<>();

        // 将起点加入优先队列
        q.offer(new State(0, 0, 0));

        // Dijkstra算法主循环
        while (!q.isEmpty()) {
            // 取出当前代价最小的位置
            State s = q.poll();

            // 如果该位置已经被访问过（已确定最短路径），则跳过
            if (v[s.x][s.y]) continue;

            // 如果到达终点，提前结束搜索（可选优化）
            if (s.x == n-1 && s.y == m-1) break;

            // 标记当前位置为已访问
            v[s.x][s.y] = true;

            // 遍历四个方向
            for (int[] dir : dirs) {
                int nx = s.x + dir[0];  // 计算新位置的x坐标
                int ny = s.y + dir[1];  // 计算新位置的y坐标

                // 检查新位置是否在网格范围内
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 关键：计算到达新位置的代价
                // Math.max(d[s.x][s.y], moveTime[nx][ny]) - 取路径上的最大移动时间
                // (s.x + s.y) % 2 + 1 - 根据当前位置的奇偶性添加额外代价（1或2）
                int dist = Math.max(d[s.x][s.y], moveTime[nx][ny]) + (s.x + s.y) % 2 + 1;

                // 如果找到更小的代价，更新距离并加入队列
                if (d[nx][ny] > dist) {
                    d[nx][ny] = dist;
                    q.offer(new State(nx, ny, dist));
                }
            }
        }
        return d[n-1][m-1];
    }
}
