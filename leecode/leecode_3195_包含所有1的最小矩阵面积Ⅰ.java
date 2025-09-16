package leecode;

public class leecode_3195_包含所有1的最小矩阵面积Ⅰ {
    public int minimumArea(int[][] grid) {
        int minLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int minUp = Integer.MAX_VALUE;
        int maxDown = Integer.MIN_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    minLeft = Math.min(minLeft, j);
                    maxRight = Math.max(maxRight, j);
                    minUp = Math.min(minUp, i);
                    maxDown = Math.max(maxDown, i);
                }
            }
        }
        return (maxRight - minLeft + 1) * (maxDown - minUp + 1);
    }
}
