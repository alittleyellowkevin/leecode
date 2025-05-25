package 贪心;

import java.util.Arrays;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 1;
        }
        Arrays.sort(intervals, (a, b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int up = intervals[0][1];
        int down = intervals[0][0];
        int number = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= up){
                up = intervals[i][1];
                down = intervals[i][0];
                continue;
            }
            number++;
            up = Math.min(intervals[i][1],up);
            down = Math.max(intervals[i][0],down);
        }
        return number;
    }

}
