package dynamic;

public class 斐波那契数 {
    public int fib(int n) {
        //1. i表示当前i位置的值

        //2. 递推公式 num[i] = num[i-1] + num[i-2]

        //3.初始化  将第一个值初始化为0 第二个为 1

        //4. 遍历顺序从 0 到 i
        int number1 = 0;
        int number2 = 1;
        if(n <= 1){
            return n;
        }
        int number3 = 0;
        for (int i = 2; i <= n; i++) {
            number3 = number1+number2;
            number1 = number2;
            number2 = number3;
        }
        return number3;
    }
}
