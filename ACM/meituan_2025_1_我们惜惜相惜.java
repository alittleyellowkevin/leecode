package ACM;
import java.util.*;
import java.io.*;

public class meituan_2025_1_我们惜惜相惜 {
    static class Pair {
        int r;
        int l;

        Pair(int r, int l) {
            this.r = r;
            this.l = l;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // 计算leftMax: 每个j左边最近的i<j且a[i]>=a[j]
            int[] leftMax = new int[n];
            Arrays.fill(leftMax, -1);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                while (!stack.isEmpty() && a[stack.peek()] < a[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    leftMax[j] = stack.peek();
                } else {
                    leftMax[j] = -1;
                }
                stack.push(j);
            }

            // 计算rightMin: 每个j右边最近的k>j且a[j]>=a[k]
            int[] rightMin = new int[n];
            Arrays.fill(rightMin, -1);
            stack.clear();
            for (int j = n - 1; j >= 0; j--) {
                while (!stack.isEmpty() && a[stack.peek()] > a[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    rightMin[j] = stack.peek();
                } else {
                    rightMin[j] = -1;
                }
                stack.push(j);
            }

            // 收集有效三元组对应的(L, R)
            List<Pair> validJs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (leftMax[j] != -1 && rightMin[j] != -1) {
                    int L = Math.min(leftMax[j], j - 1);
                    int R = Math.max(rightMin[j], j + 1);
                    if (L >= 0 && R < n) {
                        validJs.add(new Pair(R, L));
                    }
                }
            }

            // 按R排序
            Collections.sort(validJs, Comparator.comparingInt(p -> p.r));

            // 预处理maxL数组
            int[] maxL = new int[n];
            Arrays.fill(maxL, -1);
            int currentMax = -1;
            int p = 0;
            int m = validJs.size();
            for (int rPrime = 0; rPrime < n; rPrime++) {
                while (p < m && validJs.get(p).r <= rPrime) {
                    currentMax = Math.max(currentMax, validJs.get(p).l);
                    p++;
                }
                maxL[rPrime] = currentMax;
            }

            // 处理查询
            while (q-- > 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                // 转换为0-based
                int lPrime = l - 1;
                int rPrime = r - 1;

                if (r - l + 1 == 2) {
                    System.out.println("YES");
                    continue;
                }

                if (maxL[rPrime] >= lPrime) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
        scanner.close();
    }
}
