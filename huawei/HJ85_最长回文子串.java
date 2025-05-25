package huawei;

import java.util.Scanner;

public class HJ85_最长回文子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();

        int max = 1;
        for (int i = 0; i < line.length(); i++) {
            int count = 1;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < line.length() && line.charAt(left) == line.charAt(right)) {
                count += 2;
                left--;
                right++;
            }
            max = Math.max(max, count);
            if (i + 1 < line.length() && line.charAt(i) == line.charAt(i + 1)) {
                count = 2;
                left = i - 1;
                right = i + 2;
                while (left >= 0 && right < line.length() && line.charAt(left) == line.charAt(right)) {
                    count += 2;
                    left--;
                    right++;
                }
                max = Math.max(count, max);
            }
        }
        System.out.println(max);
    }
}
