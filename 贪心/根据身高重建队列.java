package 贪心;

import java.util.*;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return  b[0] - a[0];
        });
        LinkedList<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], new int[]{people[i][0], people[i][0]});
        }
        return res.toArray(new int[people.length][]);
    }
}
