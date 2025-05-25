package huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HJ110_宝石手串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int length = Integer.valueOf(in.nextLine());
            String line = in.nextLine().trim();
            System.out.println(count(line));
        }

    }

    public static int count(String line) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < line.length() * 2; i++) {
            int index = i % line.length();
            char c = line.charAt(index);
            if (map.containsKey(c)) {
                if (i - map.get(c) - 1 != line.length() - 1) {
                    count = Math.min(Math.min(i - map.get(c) - 1, count), i + line.length() - map.get(c) - 1);
                    map.put(c, i);
                }
            } else {
                map.put(c, i);
            }
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}
