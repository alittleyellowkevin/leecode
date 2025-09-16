package leecode;

public class leecode_1317_将整数转换为两个无零整数的和 {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1; i<n/2+1; i++){
            int a = i;
            int b = n - i;
            if(!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0")){
                return new int[]{a, b};
            }
        }
        return new int[]{0, 0};
    }
}
