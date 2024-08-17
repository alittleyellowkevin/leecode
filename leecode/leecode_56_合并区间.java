package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leecode_56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0]? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        List<int[]> result = new ArrayList<>();
        int border = -1;
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if(i==0 || l > border){
                result.add(new int[]{l, r});
                border = r;
            }else {
                if(r>border) {
                    int[] origin = result.get(result.size() - 1);
                    result.remove(result.size()-1);
                    result.add(new int[]{origin[0], r});
                    border = r;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
