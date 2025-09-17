package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_3446_按对角线进行矩阵排序 {
    public int[][] sortMatrix(int[][] grid) {
        // 先处理递减排序的
        for(int i=grid[0].length-1; i>=1; i--){
            List<Integer> newList = new ArrayList<>();
            int startX = 0;
            int startY = i;
            while(startX< grid.length && startY < grid[0].length){
                newList.add(grid[startX][startY]);
                startX++;
                startY++;
            }
            newList.sort((a, b)->a-b);
            startX=0;
            startY=i;
            int current = 0;
            while (startX< grid.length && startY < grid[0].length && current<newList.size()){
                grid[startX][startY] = newList.get(current);
                startX++;
                startY++;
                current++;
            }
        }
        // 再处理递增排序的
        for(int i=0; i<grid.length; i++){
            List<Integer> newList = new ArrayList<>();
            int startX = i;
            int startY = 0;
            while(startX< grid.length && startY < grid[0].length){
                newList.add(grid[startX][startY]);
                startX++;
                startY++;
            }
            newList.sort((a, b)->b-a);
            startX=0;
            startY=i;
            int current = 0;
            while (startX< grid.length && startY < grid[0].length && current<newList.size()){
                grid[startX][startY] = newList.get(current);
                startX++;
                startY++;
                current++;
            }
        }
        return grid;
    }
}
