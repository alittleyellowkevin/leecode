package dynamic;

public class 整数拆分 {
    public static void main(String[] args) {
        integerBreak(10);
    }
    public static int integerBreak(int n) {
        //nums[i] 当前i这个数最大能被拆分成多大

        //递推公式num[i] = max = Math.max(j*Math.max(numbers[i-j], i-j), max);

        //初始化numbers[2]最多被拆分为1

        //顺序无所谓

        int[] numbers = new int[n+1];
        numbers[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = i-1; j >=1 ; j--) {
                max = Math.max(j*Math.max(numbers[i-j], i-j), max);
            }
            numbers[i] = max;
        }
        return numbers[n];
    }
}
