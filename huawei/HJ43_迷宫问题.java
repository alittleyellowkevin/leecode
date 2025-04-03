package huawei;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HJ43_迷宫问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(); // 迷宫行数
            int m = in.nextInt(); // 迷宫列数

            int[][] maze = new int[n][m];
            // 读取迷宫
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = in.nextInt();
                }
            }

            List<Point> path = new ArrayList<>();
            List<Point> res = new ArrayList<>();
            maze[0][0] = -1;
            path.add(new Point(0, 0));
            findPath(maze, 0, 0, path, res);
            // 输出路径
            for (Point p : res) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }
        }
    }

    // 定义坐标点类
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void findPath(int[][] maze, int x, int y, List<Point> path, List<Point> res) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            res.clear();
            for (Point p : path) {
                res.add(new Point(p.x, p.y));
            }
        } else {
            if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                maze[x - 1][y] = -1;
                path.add(new Point(x - 1, y));
                findPath(maze, x - 1, y, path, res);
                path.remove(path.size() - 1);
                maze[x - 1][y] = 0;
            }
            if (x + 1 < maze.length && maze[x + 1][y] == 0) {
                maze[x + 1][y] = -1;
                path.add(new Point(x + 1, y));
                findPath(maze, x + 1, y, path, res);
                path.remove(path.size() - 1);
                maze[x + 1][y] = 0;
            }
            if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                maze[x][y - 1] = -1;
                path.add(new Point(x, y - 1));
                findPath(maze, x, y - 1, path, res);
                path.remove(path.size() - 1);
                maze[x][y - 1] = 0;
            }
            if (y + 1 < maze[0].length && maze[x][y + 1] == 0) {
                maze[x][y + 1] = -1;
                path.add(new Point(x, y + 1));
                findPath(maze, x, y + 1, path, res);
                path.remove(path.size() - 1);
                maze[x][y + 1] = 0;
            }

        }

    }
}