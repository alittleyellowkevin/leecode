package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 地铁耗时最短的路线 {
    public static HashMap<String, Integer> stringToInt = new HashMap<>();
    public static HashMap<Integer, String> intToString = new HashMap<>();

    public static void main(String[] args) {
        // 无向有环权重图
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int countNode = 0;
        int[][] graph = new int[n][n];
        String start = in.next();
        String end = in.next();

        for (int i = 0; i < n; i++) {
            String a = in.next();
            String b = in.next();
            if (!stringToInt.containsKey(a)) {
                stringToInt.put(a, countNode);
                intToString.put(countNode, a);
                countNode++;
            }
            if (!stringToInt.containsKey(b)) {
                stringToInt.put(b, countNode);
                intToString.put(countNode, b);
                countNode++;
            }
            int a_number = stringToInt.get(a);
            int b_number = stringToInt.get(b);
            int cost = in.nextInt();
            graph[a_number][b_number] = cost;
            graph[b_number][a_number] = cost;
        }

        int start_number = stringToInt.get(start);
        int end_number = stringToInt.get(end);
        List<String> result = new ArrayList<>();
        List<String> nowList = new ArrayList<>();
        int[] sumCost = new int[1];
        sumCost[0] = Integer.MAX_VALUE;

        nowList.add(start);
        dps(start_number, end_number, result, nowList, 0, sumCost, graph);
        System.out.println(sumCost[0]);
    }

    private static void dps(int start_number, int end_number, List<String> result, List<String> nowList, int nowCost,
            int[] sumCost, int[][] graph) {
        if (start_number == end_number && nowCost < sumCost[0]) {
            result.clear();
            sumCost[0] = nowCost;
            for (String a : nowList) {
                result.add(a);
            }
            return;
        }
        for (int i = 0; i < graph.length; i++) {
            String start = intToString.get(start_number);
            String now = intToString.get(i);
            if (!nowList.contains(now) && graph[start_number][i] > 0) {
                nowList.add(now);
                dps(i, end_number, result, nowList, nowCost + graph[start_number][i], sumCost, graph);
                nowList.remove(nowList.size() - 1);
            }
        }
    }
}
