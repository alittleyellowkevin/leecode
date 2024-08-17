package bitwise;

public class 二进制中1的个数 {
    public int NumberOf1 (int n) {
        int count=0;
        if(n<0) {
            if(n % -2 != 0){
                count++;
            }
            n = n>>>1;
        }
        while (n!=0){
            count = n%2==1?count+1:count;
            n /= 2;
        }
        return count;
    }
}
