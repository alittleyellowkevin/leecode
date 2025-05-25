package huawei;

import java.util.Scanner;

public class HJ63_DNA序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine().trim();
        int n = in.nextInt();
        int count = 0; // 当前 GC 个数
        int maxcount = 0; // 最大 GC 个数
        String res = line.substring(0, n);
        for (int i = 0; i < line.length(); i++) {
            if (i < n) {
                if (line.charAt(i) == 'G' || line.charAt(i) == 'C') {
                    count++;
                }
                maxcount = count;
                continue;
            }
            if (isGC(line.charAt(i)) && !isGC(line.charAt(i - n))) {
                count++;
                if (maxcount < count) {
                    maxcount = count;
                    res = line.substring(i - n + 1, i + 1);
                }
            } else if (!isGC(line.charAt(i)) && isGC(line.charAt(i - n))) {
                count--;
            }
        }
        System.out.println(res);
    }

    public static boolean isGC(char ac) {
        if (ac == 'G' || ac == 'C') {
            return true;
        } else {
            return false;
        }
    }
}
