package 线性表;

public class leecode_1007_行相等的最少多米诺旋转 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        for (int i = 0, same = 0; i < 6; ++i) {
            int a = 0, b = 0;
            for (int j = 0; j < n && (tops[j] == i + 1 || bottoms[j] == i + 1); ++j) {
                if (tops[j] == i + 1)
                    a++;
                if (bottoms[j] == i + 1)
                    b++;
                if (tops[j] == i + 1 && bottoms[j] == i + 1)
                    same++;
                if (j == n - 1)
                    return Math.min(n - a, n - b);
            }
        }
        return -1;
    }
}
