package 数学;

import java.util.HashMap;
import java.util.Map;

public class leecode_149_直线上最多的点数 {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        if (points.length <= 2)
            return points.length;

        int maxCount = 2;

        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> slopeCount = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                double slope = calculateSlope(points[i], points[j]);
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 1) + 1);
                maxCount = Math.max(maxCount, slopeCount.get(slope));
            }
        }

        return maxCount;
    }

    private double calculateSlope(int[] point1, int[] point2) {
        int x1 = point1[0], y1 = point1[1];
        int x2 = point2[0], y2 = point2[1];

        if (x1 == x2)
            return Double.POSITIVE_INFINITY;
        if (y1 == y2)
            return 0.0;

        return (double) (y2 - y1) / (x2 - x1);
    }

    public static void main(String[] args) {
        leecode_149_直线上最多的点数 solution = new leecode_149_直线上最多的点数();
        int[][] points = { { 7, 3 }, { 19, 19 }, { -16, 3 }, { 13, 17 }, { -18, 1 }, { -18, -17 }, { 13, -3 }, { 3, 7 },
                { -11, 12 }, { 7, 19 }, { 19, -12 }, { 20, -18 }, { -16, -15 }, { -10, -15 }, { -16, -18 }, { -14, -1 },
                { 18, 10 }, { -13, 8 }, { 7, -5 }, { -4, -9 }, { -11, 2 }, { -9, -9 }, { -5, -16 }, { 10, 14 },
                { -3, 4 }, { 1, -20 }, { 2, 16 }, { 0, 14 }, { -14, 5 }, { 15, -11 }, { 3, 11 }, { 11, -10 },
                { -1, -7 }, { 16, 7 }, { 1, -11 }, { -8, -3 }, { 1, -6 }, { 19, 7 }, { 3, 6 }, { -1, -2 }, { 7, -3 },
                { -6, -8 }, { 7, 1 }, { -15, 12 }, { -17, 9 }, { 19, -9 }, { 1, 0 }, { 9, -10 }, { 6, 20 }, { -12, -4 },
                { -16, -17 }, { 14, 3 }, { 0, -1 }, { -18, 9 }, { -15, 15 }, { -3, -15 }, { -5, 20 }, { 15, -14 },
                { 9, -17 }, { 10, -14 }, { -7, -11 }, { 14, 9 }, { 1, -1 }, { 15, 12 }, { -5, -1 }, { -17, -5 },
                { 15, -2 }, { -12, 11 }, { 19, -18 }, { 8, 7 }, { -5, -3 }, { -17, -1 }, { -18, 13 }, { 15, -3 },
                { 4, 18 }, { -14, -15 }, { 15, 8 }, { -18, -12 }, { -15, 19 }, { -9, 16 }, { -9, 14 }, { -12, -14 },
                { -2, -20 }, { -3, -13 }, { 10, -7 }, { -2, -10 }, { 9, 10 }, { -1, 7 }, { -17, -6 }, { -15, 20 },
                { 5, -17 }, { 6, -6 }, { -11, -8 } };
        int result = solution.maxPoints(points);
        System.out.println("最多点数: " + result);
    }
}
