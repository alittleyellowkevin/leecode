package 动态规划;

public class JZ_83_剪绳子 {
    public int cutRope(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = i;
            for (int j = 1; j < i; j++) {
                max = Math.max(j * res[i - j], max);
            }
            res[i] = max;
        }
        return res[n];
    }
}
