package dynamic;

public class leecode_279_完全平方数 {
    public static void main(String[] args) {
        numSquares(12);
    }

    public static int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                res[i] = 0;
            } else {
                res[i] = -1;
            }
        }
        for (int i = 1; i < (int) Math.sqrt(n) + 1; i++) {
            int squre = i * i;
            for (int j = squre; j <= n; j++) {
                // 当前值是否可达
                if (res[j] == -1) {
                    // 当前值不可达
                    if (res[j - squre] != -1) {
                        // 若取该硬币则可达直接加一
                        res[j] = res[j - squre] + 1;
                    }
                    // 否则不变
                } else {
                    // 当前值可达时
                    if (res[j - squre] != -1) {
                        // 取该硬币也可达时
                        res[j] = Math.min(res[j - squre] + 1, res[j]);
                    }
                }
            }
        }
        return res[n];
    }
}
