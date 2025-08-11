package hotcode100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leecode_994_腐烂的橘子 {
    int maxLength = 0;
    boolean[][] visit;
    public int orangesRotting(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visit[i][j] = false; //没被访问过
            }
        }
        bfs(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return maxLength;
    }

    private void bfs(int[][] grid) {
        Queue<int[]> nodeQueue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){
                    nodeQueue.add(new int[]{i, j});
                }
            }
        }
        int countlen = 0;
        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            for(int k=0; k<size; k++){
                int[] node = nodeQueue.poll();
                int left = node[0];
                int right = node[1];
                visit[left][right] = true;
                if(left+1 < grid.length && !visit[left+1][right] && grid[left+1][right] == 1){
                    grid[left+1][right] = 2;
                    nodeQueue.add(new int[]{left+1, right});
                }
                if(left-1 >= 0  && !visit[left-1][right] && grid[left-1][right] == 1){
                    grid[left-1][right] = 2;
                    nodeQueue.add(new int[]{left-1, right});
                }
                if(right+1 < grid[0].length && !visit[left][right+1] && grid[left][right+1] == 1){
                    grid[left][right+1] = 2;
                    nodeQueue.add(new int[]{left, right+1});
                }
                if(right-1 >= 0 && !visit[left][right-1] && grid[left][right-1] == 1){
                    grid[left][right-1] = 2;
                    nodeQueue.add(new int[]{left, right-1});
                }
            }
            countlen++;
        }
        maxLength = Math.max(countlen-1, maxLength);
    }
}
