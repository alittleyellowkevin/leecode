package leecode;

public class leecode_7_整数反转 {
    public int reverse(int x) {
        int res=0;
        while (x!=0){
            if(res<=Integer.MAX_VALUE/10 && res>=Integer.MIN_VALUE/10){
                res = res*10 +x%10;
                x /= 10;
            }else {
                return 0;
            }
        }
        return res;
    }
}
