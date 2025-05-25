package 线性表;

public class leecode_59_螺旋矩阵Ⅱ {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        right(0, 0, res, 1);
        return res;
    }

    public static void right(int i, int j, int[][] res, int count) {
        if (count == res.length * res[0].length) {
            res[i][j] = count;
        } else {
            res[i][j] = count;
            if (j + 1 < res.length && res[i][j + 1] == 0) {
                right(i, j + 1, res, count + 1);
            } else {
                down(i, j, res, count);
            }
        }
    }

    private static void down(int i, int j, int[][] res, int count) {
        if (count == res.length * res[0].length) {
            res[i][j] = count;
        } else {
            res[i][j] = count;
            if (i + 1 < res.length && res[i + 1][j] == 0) {
                down(i + 1, j, res, count + 1);
            } else {
                left(i, j, res, count);
            }
        }
    }

    private static void left(int i, int j, int[][] res, int count) {
        if (count == res.length * res[0].length) {
            res[i][j] = count;
        } else {
            res[i][j] = count;
            if (j - 1 >= 0 && res[i][j - 1] == 0) {
                left(i, j - 1, res, count + 1);
            } else {
                up(i, j, res, count);
            }
        }
    }

    private static void up(int i, int j, int[][] res, int count) {
        if (count == res.length * res[0].length) {
            res[i][j] = count;
        } else {
            res[i][j] = count;
            if (i - 1 >= 0 && res[i - 1][j] == 0) {
                up(i - 1, j, res, count + 1);
            } else {
                right(i, j, res, count);
            }
        }
    }
}
