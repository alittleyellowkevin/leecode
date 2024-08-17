package leecode;

public class leecode_50_Pow {
    public double myPow(double x, int n) {
        return n>0? powd(x, n):1/powd(x, -n);
    }

    private double powd(double x, int n) {
        if(n == 0){
            return 1;
        }else {
            double y = powd(x, n/2);
            return n%2==0? y*y:y*y*x;
        }
    }
}
