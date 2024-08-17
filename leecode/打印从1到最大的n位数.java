package leecode;

public class 打印从1到最大的n位数 {
    public int[] printNumbers (int n) {
        int number = (int) Math.pow(10, n);
        int[] res = new int[number-1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i+1;
        }
        return res;
        // write code here
    }
}
