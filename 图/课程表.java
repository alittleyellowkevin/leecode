package 图;

public class 课程表 {
    public static void main(String[] args) {
        canFinish(2, new int[][] { { 1, 0 } });
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int now = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph[pre][now] = 1;
        }

        boolean flag = true;
        while (flag) {
            int countNumber = 0;
            for (int i = 0; i < graph.length; i++) {
                if (count(i, graph)) {
                    remove(i, graph);
                    countNumber++;
                }
            }
            flag = countNumber > 0;
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void remove(int i, int[][] graph) {
        for (int j = 0; j < graph.length; j++) {
            graph[i][j] = 0;
        }
    }

    private static boolean count(int i, int[][] graph) {
        for (int j = 0; j < graph.length; j++) {
            if (graph[j][i] == 1) {
                return false;
            }
        }
        return true;
    }
}
