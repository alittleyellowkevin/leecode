package greedy;

import java.util.*;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        if(intervals.length == 1){
            return intervals;
        }
        int down = intervals[0][0];
        int up = intervals[0][1];
        LinkedList<int[]> link = new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>up){
                link.add(new int[]{down, up});
                up = intervals[i][1];
                down = intervals[i][0];
                continue;
            }
            up = Math.max(up, intervals[i][1]);
        }
        return link.toArray(new int[link.size()][]);
    }
}
