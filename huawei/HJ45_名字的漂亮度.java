package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ45_名字的漂亮度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            String line = in.nextLine();

            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < line.length(); i++) {
                treeMap.put(line.charAt(i), treeMap.getOrDefault(line.charAt(i), 0) + 1);
            }
            List<Integer> list = new ArrayList<>(treeMap.values());
            list.sort(Collections.reverseOrder());

            int result = 0;
            int count = 26;
            for (int i = 0; i < list.size(); i++) {
                result += list.get(i) * count;
                count--;
            }
            res.add(result);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
