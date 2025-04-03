package huawei;

import java.util.Scanner;
import java.util.TreeMap;

public class HJ8_合并表记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            TreeMap<Long, Long> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                long index = in.nextLong();
                long value = in.nextLong();
                map.put(index, map.getOrDefault(index, 0L) + value);
            }
            for (long key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
