package 动态规划;

import java.util.TreeMap;

public class leecode_1399_统计最大组的数目 {
    public static void main(String[] args) {
    }

    public static int countLargestGroup(int n) {
        TreeMap<Integer, Integer> sumToCountMap = new TreeMap<>();
        int sum = 0;
        int sumCount = 0;
        for (int i = 1; i <= n; i++) {
            int key = count(i);
            sumToCountMap.put(key, sumToCountMap.getOrDefault(key, 0) + 1);
        }
        for (Integer key : sumToCountMap.keySet()) {
            Integer value = sumToCountMap.get(key);
            if (value > sum) {
                sum = value;
                sumCount = 1;
            } else if (value == sum) {
                sumCount++;
            }
        }
        return sumCount;
    }

    public static int count(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
