package 贪心;

import java.util.Arrays;

public class 用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        int[][] points ={{-2147483646,-2147483645},{2147483646,2147483647}};
        findMinArrowShots(points);
    }
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 1){
            return 1;
        }
        Arrays.sort(points, (a, b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int up = points[0][1];
        int down = points[0][0];
        int number = 1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > up){
                number++;
                up = points[i][1];
                down = points[i][0];
                continue;
            }
            up = Math.min(points[i][1],up);
            down = Math.max(points[i][0],down);
        }
        return number;
    }
}
