package tree;

public class leecode_62_不同路径 {
    //回溯
    public int uniquePaths(int m, int n) {
        int[] count = new int[1];
        count[0] = 0;
        huisu(m, n, count);
        return count[0];
    }

    private void huisu(int m, int n, int[] count) {
        if(m == 0 && n == 0){
            count[0] = count[0] + 1;
        }
        if(m>0){
            huisu(m-1, n, count);
        }
        if(n>0){
            huisu(m, n-1, count);
        }
    }
}
