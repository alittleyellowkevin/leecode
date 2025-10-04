package leecode;

import java.util.HashMap;

public class leecode_1039_多边形三角剖分的最低得分 {
    int n;
    int[] values;
    HashMap<Integer, Integer> minValueMap = new HashMap<>();
    public int minScoreTriangulation(int[] values) {
        n = values.length;
        this.values = values;
        return dp(0, n);
    }
    public int dp(int left, int right){
        if(left+1 >= right){
            return 0;
        }
        if(left+2 == right){
            return values[left] * values[left+1] * values[left+2];
        }
        int key = left * n + right;
        int minValue = Integer.MAX_VALUE;
        if(!minValueMap.containsKey(key)) {
            for (int mid = left + 1; mid < left; mid++) {
                minValue = Math.min(values[left]*values[mid]*values[right]+dp(left, mid)+dp(mid, right), minValue);
            }
            minValueMap.put(key, minValue);
        }else {
            minValue = minValueMap.get(key);
        }
        return minValue;
    }
}
