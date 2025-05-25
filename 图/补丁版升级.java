package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 补丁版升级 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String nowVersion = in.next();
            String preVersion = in.next();
            if (preVersion.equals("NA")) {
                if (!map.containsKey(nowVersion)) {
                    map.put(nowVersion, new ArrayList<>());
                }
            } else {
                if (map.containsKey(preVersion)) {
                    map.get(preVersion).add(nowVersion);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(nowVersion);
                    map.put(preVersion, list);
                }
            }
        }
        int[] result = new int[1];
        result[0] = 0;
        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String head = entry.getKey();
            resList.add(head);
            dfs(head, 1, result, map, resList);
        }
        System.out.println(result[0]);
    }

    private static void dfs(String head, int size, int[] resSize, Map<String, List<String>> map, List<String> resList) {
        if (resSize[0] < size) {
            resList.clear();
            resSize[0] = size;
            resList.add(head);
        } else if (resSize[0] == size) {
            resList.add(head);
        }
        List<String> neigbStrings = map.get(head);
        if (neigbStrings != null && neigbStrings.size() > 0) {
            for (String neignbor : neigbStrings) {
                dfs(neignbor, size + 1, resSize, map, resList);
            }
        }
    }
}
