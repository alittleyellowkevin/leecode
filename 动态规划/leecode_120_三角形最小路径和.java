package 动态规划;

import java.util.List;

public class leecode_120_三角形最小路径和 {
    int res = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        // 1. dp[i][j]表示当前点的最小路径

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 3. 递推方程dp[i][j] = dp[i-1][j] 如果j存在 或dp[i-1][j-1]如果j-1
                triangle.get(i).set(j,
                        triangle.get(i).get(j) + Math.min(j - 1 >= 0 ? triangle.get(i - 1).get(j) : Integer.MAX_VALUE,
                                j < triangle.get(i - 1).size() ? triangle.get(i - 1).get(j) : Integer.MAX_VALUE));
                if (i == triangle.size() - 1) {
                    // 2. 初始化
                    res = Math.min(triangle.get(i).get(j), res);
                }
            }
        }
        return res;
    }
}
