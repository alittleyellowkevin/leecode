package ACM;

import java.util.Scanner;

public class xiaomi_2025_1_爬山 {
    static boolean can(int x, int n, int k, int[] h) {
        boolean[][] dp = new boolean[n][k + 1];
        dp[0][0] = true;
        if (k > 0) dp[0][1] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (!dp[i - 1][j]) continue;

                // 不改第i座山
                if (Math.abs(h[i] - h[i - 1]) <= x) {
                    dp[i][j] = true;
                }
                // 改第i座山
                if (j + 1 <= k) {
                    dp[i][j + 1] = true;
                }
            }
        }

        for (int j = 0; j <= k; j++) {
            if (dp[n - 1][j]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }

            int left = 0, right = 2000000000, ans = right;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (can(mid, n, k, h)) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
}
