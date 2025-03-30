package number;

public class leecode_69_x的平方根 {
    public int mySqrt(int x) {
        int number=0;
        for (int i = 0; i < x/2+1; i++) {
            if(i*i<= x && x<(i+1)*(i+1)){
                number = i;
                break;
            }
        }
        return number;
    }
}
