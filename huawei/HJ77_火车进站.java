package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HJ77_火车进站 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        // 递归生成所有可能的出站序列
        dfs(array, 0, stack, "", result, new boolean[n]);

        // 按字典序排序并输出
        Collections.sort(result);
        for (String s : result) {
            System.out.println(s.trim());
        }
    }

    // 递归生成所有可能的出站序列
    private static void dfs(int[] array, int index, Stack<Integer> stack, String path, List<String> result,
            boolean[] used) {
        // 当所有火车都处理完时,将当前路径加入结果集
        if (index == array.length && stack.isEmpty()) {
            result.add(path);
            return;
        }

        // 尝试让火车进站
        if (index < array.length && !used[index]) {
            stack.push(array[index]);
            used[index] = true;
            dfs(array, index + 1, stack, path, result, used);
            stack.pop();
            used[index] = false;
        }

        // 尝试让火车出站
        if (!stack.isEmpty()) {
            int value = stack.pop();
            dfs(array, index, stack, path + value + " ", result, used);
            stack.push(value);
        }
    }
}
