package leecode;

public class leecode_70_爬楼梯 {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        } else if (n==2) {
            return 2;
        }
        int one = 1;
        int two = 2;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
