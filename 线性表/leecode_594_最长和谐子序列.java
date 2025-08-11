package 线性表;

import java.util.HashMap;

public class leecode_594_最长和谐子序列 {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE + 1;
        System.out.println(a);
    }
    public int findLHS(int[] nums) {

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if(map.get(key+1) != null) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
            if(map.get(key-1) != null) {
                max = Math.max(max, map.get(key) + map.get(key - 1));
            }
        }
        return max;
    }
}
