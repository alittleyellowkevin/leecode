package 线性表;

import java.util.HashMap;

public class leecode_1128_等价多米诺骨牌对的数量 {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] dominoe = dominoes[i];
            int left = dominoe[0] <= dominoe[1] ? dominoe[0] : dominoe[1];
            int right = dominoe[0] > dominoe[1] ? dominoe[0] : dominoe[1];
            String key = left + "+" + right;
            map.put(key, map.getOrDefault(key, 0) + 1);
            int value = map.get(key);
            count += ((value * (value - 1) / 2) - ((value - 1) * (value - 2) / 2));
        }
        return count;
    }
}
