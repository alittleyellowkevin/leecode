package array;

import java.util.ArrayList;
import java.util.List;

public class leecode_57_插入区间 {
    public static void main(String[] args) {
        int[][] intervals =  {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newint = {4, 8};
        int[][] merged = insert2(intervals, newint);
        for (int i = 0;  i< merged.length; i++) {
            for (int j = 0; j < merged[0].length; j++) {
                System.out.println(merged[i][j]);
            }
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]){
                merged.add(new int[]{intervals[i][0], intervals[i][1]});
            }else {
                int min = intervals[i][0];
                int max = Math.max(intervals[i][1], newInterval[1]);
                if(i+1 < intervals.length){
                    i++;
                    while(!(intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1])){
                        max = Math.max(intervals[i][1], newInterval[1]);
                        i++;
                    }
                    i--;
                    merged.add(new int[]{min, max});
                }else {
                    merged.add(new int[]{min, max});
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        if(intervals.length == 0){
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }

        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] <= newInterval[0] && newInterval[0] <=intervals[i][1])
            {
                int l = intervals[i][0];
                while (newInterval[1]>intervals[i][1]){
                    i++;
                }
                if(newInterval[1] < intervals[i][0]){
                    list.add(new int[]{l, newInterval[1]});
                    i--;
                }else {
                    list.add(new int[]{l, intervals[i][1]});
                }
            }else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }


        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
