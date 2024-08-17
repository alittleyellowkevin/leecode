package backtrack;

public class 机器人的运动范围 {
    public static void main(String[] args) {
        movingCount(10,1 , 100);
    }
    static int number = 0;
    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        flag[0][0] = true;
        walk(threshold, 0, 0, flag);
        return number;
    }

    private static void walk(int threshold, int i, int j, boolean[][] flag) {
        if(ableWalk(threshold, i+1, j, flag)){
            flag[i+1][j] = true;
            number++;
            walk(threshold, i+1, j, flag);
        }
        if(ableWalk(threshold, i-1, j, flag)){
            flag[i-1][j] = true;
            number++;
            walk(threshold, i-1, j, flag);
        }
        if(ableWalk(threshold, i, j+1, flag)){
            flag[i][j+1] = true;
            number++;
            walk(threshold, i, j+1, flag);
        }
        if(ableWalk(threshold, i, j-1, flag)){
            flag[i][j-1] = true;
            number++;
            walk(threshold, i, j-1, flag);
        }

    }

    private static boolean ableWalk(int threshold, int i, int j, boolean[][] flag) {
        return i < flag.length && i >= 0 && j < flag[0].length && j >= 0 && !flag[i][j] && (change(i) + change(j) <= threshold);
    }


    private static int change(int number) {
        int sum = 0;
        while (number!=0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

}
