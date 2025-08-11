package hotcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class leecode_56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        ArrayList<int[]> result = new ArrayList();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if(currentStart <= end){
                end = Math.max(end, currentEnd);
            }else {
                // 收集当前 start 和 end
                result.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}
