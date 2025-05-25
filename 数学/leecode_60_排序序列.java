package 数学;

import java.util.PriorityQueue;

public class leecode_60_排序序列 {
    public static void main(String[] args) {
        leecode_60_排序序列 solution = new leecode_60_排序序列();
        int n = 3;
        int k = 3;
        System.out.println(solution.getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        // 总共有 n!个 ，如何确定第一个元素 用 k 除以 n-1!
        int[] numberArray = new int[n + 1];
        int sum = 1;
        // List<Integer>
        for (int i = 1; i < numberArray.length; i++) {
            sum *= i;
            numberArray[i] = sum;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int margin = numberArray[(n - i - 1)];
            if (margin == 0) {
                break;
            }
            int curNumber = k / margin + 1;
            k = k % margin;
            sb.append(curNumber);
        }

        return sb.toString();
    }
}
