package leecode;

public class leecode_69_x的平方根 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left<=right){
            long mid = (left + right)/2;
            if(mid*mid>x){
                right = (int)mid;
            } else if ((mid+1)*(mid+1)<=x) {
                left = (int)(mid+1);
            }else {
                return (int)mid;
            }
        }
        return 0;
    }
}
